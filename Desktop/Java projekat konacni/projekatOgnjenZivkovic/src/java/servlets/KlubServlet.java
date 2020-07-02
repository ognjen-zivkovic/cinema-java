package servlets;

import beans.Klub;
import beans.Korisnik;
import dao.KlubDao;
import dao.KorisnikDao;
import daoimpl.KlubDaoImpl;
import daoimpl.KorisnikDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ognjen Živković
 */
public class KlubServlet extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        if (request.getParameter("uclanjenje") != null)
        {
            Korisnik korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
            if (korisnik == null)
            {
                request.setAttribute("logovanje", true);
                KlubDao klubDao = new KlubDaoImpl();
                Klub klub = klubDao.getById(Integer.parseInt(request.getParameter("uclanjenje")));
                request.setAttribute("klub", klub);
            }
            else
            {
                KorisnikDao korisnikDao = new KorisnikDaoImpl();
                int rows = korisnikDao.setKlub(Integer.parseInt(request.getParameter("uclanjenje")),korisnik.getKorisnikId());
                if(rows > 0)
                {
                     request.setAttribute("uspesno", true);
                }
                else
                {
                    request.setAttribute("greska", true);
                }
                KlubDao klubDao = new KlubDaoImpl();
                Klub klub = klubDao.getById(Integer.parseInt(request.getParameter("uclanjenje")));
                request.setAttribute("klub", klub);
            }

        }
        else if (request.getParameter("klubId") != null)
        {
            KlubDao klubDao = new KlubDaoImpl();
            Klub klub = klubDao.getById(Integer.parseInt(request.getParameter("klubId")));
            request.setAttribute("klub", klub);
        }
        request.getRequestDispatcher("porodicniKlub.jsp").forward(request, response);
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
