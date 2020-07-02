package servlets;

import beans.Bioskop;
import beans.Film;
import beans.Projekcija;
import com.google.gson.Gson;
import dao.BioskopDao;
import dao.FilmDao;
import dao.ProjekcijaDao;
import dao.Projekciona_SalaDao;
import daoimpl.BioskopDaoImpl;
import daoimpl.FilmDaoImpl;
import daoimpl.ProjekcijaDaoImpl;
import daoimpl.Projekciona_SalaDaoImpl;
import dto.AdminProjekcijaDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
public class adminProjekcije extends HttpServlet
{

    private Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ProjekcijaDao projekcijaDao = new ProjekcijaDaoImpl();
        BioskopDao bioskopDao = new BioskopDaoImpl();
        FilmDao filmDao = new FilmDaoImpl();
        Projekciona_SalaDao projekciona_SalaDao = new Projekciona_SalaDaoImpl();
        if (request.getParameter("film") != null)
        {
            Date datumProjekcije = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try
            {
                datumProjekcije = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").parse(request.getParameter("vremePocetka"));
            } catch (ParseException ex)
            {
                System.out.println(ex.getMessage());
            }
            String datumProjekcijeFormatiran = sdf.format(datumProjekcije);
            int filmId = Integer.parseInt(request.getParameter("film"));
            int bioskopId = Integer.parseInt(request.getParameter("bioskop"));
            int brojSale = Integer.parseInt(request.getParameter("brojSale"));
            double cena;
            try
            {
                cena = Double.parseDouble(request.getParameter("cena"));
                int rows = projekcijaDao.addProjekcija(filmId, bioskopId, brojSale, cena, datumProjekcijeFormatiran);
                if (rows > 0)
                {
                    request.setAttribute("uspesnoDodato", true);
                }
                else
                {
                    request.setAttribute("greska", true);
                }
            } 
            catch (Exception ex)
            {
                request.setAttribute("pogresnaCena", true);
            }

            List<AdminProjekcijaDto> projekcije = projekcijaDao.getAllByBioskop(bioskopId);
            List<Bioskop> bioskopi = bioskopDao.getAll();
            String nazivTrenutnogBioskopa = "";
            for (Bioskop b : bioskopi)
            {
                if (b.getBioskopId() == bioskopId)
                {
                    nazivTrenutnogBioskopa = b.getGradNaziv();
                }
            }
            request.setAttribute("projekcije", projekcije);
            request.setAttribute("bioskopi", bioskopi);
            request.setAttribute("trenutniBioskop", nazivTrenutnogBioskopa);
            request.getRequestDispatcher("adminProjekcije.jsp").forward(request, response);

        }
        else if (request.getParameter("popuniSelect") != null)
        {
            int bioskopId = Integer.parseInt(request.getParameter("popuniSelect"));
            List<Integer> sale = projekciona_SalaDao.getByBioskop(bioskopId);
            response.setContentType("application/json");
            response.setContentType("text/html;charset=UTF-8");
            String json = this.gson.toJson(sale);
            PrintWriter out = response.getWriter();

            out.print(json);
            out.flush();
        }
        else if (request.getParameter("novaProjekcija") != null)
        {
            response.setContentType("application/json");
            response.setContentType("text/html;charset=UTF-8");
            List<Film> filmovi = filmDao.getAllFilmovi();
            List<Bioskop> bioskopi = bioskopDao.getAll();
            String json1 = this.gson.toJson(filmovi);
            String json2 = this.gson.toJson(bioskopi);
            String bothJson = "[" + json1 + "," + json2 + "]";
            PrintWriter out = response.getWriter();

            out.print(bothJson);
            out.flush();
        }
        else if (request.getParameter("bioskopId") != null)
        {
            int bioskopId = Integer.parseInt(request.getParameter("bioskopId"));
            List<AdminProjekcijaDto> projekcije = projekcijaDao.getAllByBioskop(bioskopId);
            List<Bioskop> bioskopi = bioskopDao.getAll();
            String nazivTrenutnogBioskopa = "";
            for (Bioskop b : bioskopi)
            {
                if (b.getBioskopId() == bioskopId)
                {
                    nazivTrenutnogBioskopa = b.getGradNaziv();
                }
            }
            request.setAttribute("projekcije", projekcije);
            request.setAttribute("bioskopi", bioskopi);
            request.setAttribute("trenutniBioskop", nazivTrenutnogBioskopa);
            request.getRequestDispatcher("adminProjekcije.jsp").forward(request, response);
        }
        else if (request.getParameter("projekcijaId") != null)
        {
            int projekcijaId = Integer.parseInt(request.getParameter("projekcijaId"));
            Projekcija temp = projekcijaDao.getById(projekcijaId);
            int rows = projekcijaDao.deleteById(projekcijaId);
            if (rows > 0)
            {
                request.setAttribute("obrisano", true);
            }
            else
            {
                request.setAttribute("greska", true);
            }
            List<AdminProjekcijaDto> projekcije = projekcijaDao.getAllByBioskop(temp.getBioskopId());
            List<Bioskop> bioskopi = bioskopDao.getAll();
            String nazivTrenutnogBioskopa = "";
            for (Bioskop b : bioskopi)
            {
                if (b.getBioskopId() == temp.getBioskopId())
                {
                    nazivTrenutnogBioskopa = b.getGradNaziv();
                }
            }
            request.setAttribute("projekcije", projekcije);
            request.setAttribute("bioskopi", bioskopi);
            request.setAttribute("trenutniBioskop", nazivTrenutnogBioskopa);
            request.getRequestDispatcher("adminProjekcije.jsp").forward(request, response);

        }
        else
        {
            List<AdminProjekcijaDto> projekcije = projekcijaDao.getAllByBioskop(1);
            List<Bioskop> bioskopi = bioskopDao.getAll();
            request.setAttribute("projekcije", projekcije);
            request.setAttribute("bioskopi", bioskopi);
            request.setAttribute("trenutniBioskop", "Beograd");
            request.getRequestDispatcher("adminProjekcije.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
