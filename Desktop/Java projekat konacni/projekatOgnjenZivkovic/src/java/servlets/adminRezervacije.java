package servlets;

import beans.Rezervacija;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.RezervacijaDao;
import daoimpl.RezervacijaDaoImpl;
import dto.AdminRezervacijaDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ognjen Živković
 */
public class adminRezervacije extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException
    {
        RezervacijaDao rezervacijaDao = new RezervacijaDaoImpl();
        if (request.getParameter("promenaStatusa") != null)
        {
            int rezervacijaId = Integer.parseInt(request.getParameter("promenaStatusa"));
            int rows = rezervacijaDao.promeniStatus(rezervacijaId, "Preuzeta karta");
            Gson gson = new Gson();
            String json = "{\"id\": " + rezervacijaId + " }";
            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

            PrintWriter out = response.getWriter();

            out.print(jsonObject);
            out.flush();
        }
        else if (request.getParameter("rezervacijaId") != null)
        {
            int rows = rezervacijaDao.deleteById(Integer.parseInt(request.getParameter("rezervacijaId")));
            if (rows > 0)
            {
                request.setAttribute("obrisano", true);
            }
            else
            {
                request.setAttribute("greska", true);
            }
            List<AdminRezervacijaDto> rezervacije = rezervacijaDao.displayRezervacije();
            for (int i = 0; i < rezervacije.size(); i++)
            {
                List<Integer> sedista = rezervacijaDao.sedistaByRezervacija(rezervacije.get(i).getRezervacijaId());
                rezervacije.get(i).setSedista(sedista);

            }
            request.setAttribute("rezervacije", rezervacije);
            request.getRequestDispatcher("adminRezervacije.jsp").forward(request, response);
        }
        else
        {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String trenutnoVreme = sdf.format(new Date());
            Date trenutniDatum = new Date();

            List<AdminRezervacijaDto> rezervacije = rezervacijaDao.displayRezervacije();
            //ime promenljive datumRezervacije treba da bude datum projekcije

            for (int i = 0; i < rezervacije.size(); i++)
            {
                Date datumRezervacije = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rezervacije.get(i).getVremePocetka());
                String vremeRezervacije = sdf.format(datumRezervacije);
                if (reservationExpired(datumRezervacije, trenutniDatum, trenutnoVreme, vremeRezervacije))
                {
                    rezervacijaDao.promeniStatus(rezervacije.get(i).getRezervacijaId(), "Istekla rezervacija");
                    rezervacije.get(i).setStatus("Istekla rezervacija");
                }
                List<Integer> sedista = rezervacijaDao.sedistaByRezervacija(rezervacije.get(i).getRezervacijaId());
                rezervacije.get(i).setSedista(sedista);
            }
            request.setAttribute("rezervacije", rezervacije);
            request.getRequestDispatcher("adminRezervacije.jsp").forward(request, response);
        }

    }

    private boolean reservationExpired(Date datumRezervacije, Date trenutniDatum, String trenutnoVreme, String vremeRezervacije)
    {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try
        {
            if (!datumRezervacije.before(trenutniDatum))
            {
                long diff = datumRezervacije.getTime() - trenutniDatum.getTime();
                long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                if(days>0)
                {
                    return false;
                }
                //System.out.println("Broj dana po rezervaciji:"+days);
                Date d1 = sdf.parse(trenutnoVreme);
                Date d2 = sdf.parse(vremeRezervacije);
                long elapsed = (d2.getTime() - d1.getTime()) / 1000 / 60;

                if (elapsed >= 30)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (ParseException ex)
        {
            Logger.getLogger(adminRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (ParseException ex)
        {
            Logger.getLogger(adminRezervacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
