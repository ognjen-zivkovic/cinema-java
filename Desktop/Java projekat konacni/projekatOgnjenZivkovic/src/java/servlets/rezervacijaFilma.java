package servlets;

import beans.Korisnik;
import beans.Projekcija;
import beans.Projekciona_Sala;
import beans.Sediste;
import beans.Sediste_Rezervisano;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.FilmDao;
import dao.KorisnikDao;
import dao.ProjekcijaDao;
import dao.Projekciona_SalaDao;
import dao.RezervacijaDao;
import dao.SedisteDao;
import dao.Sediste_RezervisanoDao;
import daoimpl.FilmDaoImpl;
import daoimpl.KorisnikDaoImpl;
import daoimpl.ProjekcijaDaoImpl;
import daoimpl.Projekciona_SalaDaoImpl;
import daoimpl.RezervacijaDaoImpl;
import daoimpl.SedisteDaoImpl;
import daoimpl.Sediste_RezervisanoDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ognjen Živković
 */
public class rezervacijaFilma extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet rezervacijaFilma</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet rezervacijaFsdfsdilma at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //rezervacija karata
        if (request.getParameter("projekcijaId") != null)
        {
            String[] sedista = request.getParameterValues("sedista[]");
            int projekcijaId = Integer.parseInt(request.getParameter("projekcijaId"));
            String cena = request.getParameter("cena");
            ProjekcijaDao projekcijaDao = new ProjekcijaDaoImpl();
            Projekcija projekcija = projekcijaDao.getById(projekcijaId);
            RezervacijaDao rezervacijaDao = new RezervacijaDaoImpl();

            Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
            KorisnikDao korisnikDao = new KorisnikDaoImpl();
            korisnikDao.updatePoeni(korisnik.getKorisnikId(), Integer.parseInt(cena));
            //popust na svakih 10000 poena
            if (korisnik.getBrojPoena() > 10000)
            {
                int temp = Integer.parseInt(cena);
                temp /= 2;
                cena = String.valueOf(temp);
                korisnikDao.resetPoeni(korisnik.getKorisnikId());
            }
            //20% popusta ako je clan kluba
            if(korisnik.getKlubId() == 3)
            {
                int temp = Integer.parseInt(cena);
                temp *= 0.8;
                cena = String.valueOf(temp);
            }
            
            int rows = rezervacijaDao.insertIntoRezervacija("Aktivna", korisnik.getKorisnikId(), projekcijaId, cena);
            if (rows == 0)
            {
                response.setContentType("text/plain");
                response.getWriter().write("Greska");
            }
            int rezervacijaMaxId = rezervacijaDao.getMaxId();
            Sediste_RezervisanoDao sediste_rezervisanoDao = new Sediste_RezervisanoDaoImpl();
            for (int i = 0; i < sedista.length; i++)
            {
                int brojSedista = Integer.parseInt(sedista[i]);
                int rows2 = sediste_rezervisanoDao.insertIntoSedisteRezervisano(rezervacijaMaxId, projekcijaId, brojSedista, projekcija.getBrojSale(), projekcija.getBioskopId());
            }

            Gson gson = new Gson();
            String json = "{\"uspeh\": \"true\" }";
            JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

            PrintWriter out = response.getWriter();

            out.print(jsonObject);
            out.flush();
            //rezervacija karata
        }
        else
        {

            ProjekcijaDao projekcijaDao = new ProjekcijaDaoImpl();
            Projekcija projekcija = projekcijaDao.getById(Integer.parseInt(request.getAttribute("projekcijaId").toString()));
            SedisteDao sedisteDao = new SedisteDaoImpl();
            List<Sediste> sedista = sedisteDao.getAllByBrojSaleAndBioskop(projekcija.getBrojSale(), projekcija.getBioskopId());
            request.setAttribute("projekcija", projekcija);
            Sediste_RezervisanoDao sediste_RezervisanoDao = new Sediste_RezervisanoDaoImpl();
            List<Sediste_Rezervisano> rezervisana_Sedista = sediste_RezervisanoDao.getAllByProjekcija(projekcija.getProjekcijaId());

            Projekciona_SalaDao psDao = new Projekciona_SalaDaoImpl();
            Projekciona_Sala sala = psDao.getByIdAndBioskop(projekcija.getBrojSale(), projekcija.getBioskopId());
            request.setAttribute("ukupanBrojSedista", sala.getUkupanBrojSedista());

            int filmId = Integer.parseInt(request.getAttribute("filmId").toString());
            FilmDao dao = new FilmDaoImpl();
            request.setAttribute("film", dao.getById(filmId));
            LinkedHashMap<Sediste, Boolean> ispis = new LinkedHashMap<Sediste, Boolean>();
            List<Integer> brojeviSedista = new ArrayList<Integer>();
            for (Sediste_Rezervisano sr : rezervisana_Sedista)
            {
               
                brojeviSedista.add(sr.getBrojSedista());
            }
            for (int i = 0; i < sedista.size(); i++)
            {

                if (brojeviSedista.contains(sedista.get(i).getBrojSedista()))
                {
                    
                    ispis.put(sedista.get(i), true);
                }
                else
                {
                    ispis.put(sedista.get(i), false);
                }
            }
            request.setAttribute("ispisSedista", ispis);
            request.getRequestDispatcher("rezervacijaFilma.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
