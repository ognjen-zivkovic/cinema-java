package servlets;

import beans.Korisnik;
import dao.KorisnikDao;
import daoimpl.KorisnikDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ognjen Živković
 */
public class Register extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String email = request.getParameter("email");
        String lozinka = request.getParameter("lozinka");
        if (ime != null && !ime.isEmpty() && prezime != null && !prezime.isEmpty() && email != null && !email.isEmpty() && lozinka != null && !lozinka.isEmpty())
        {
            KorisnikDao korisnikDao = new KorisnikDaoImpl();
            if (korisnikDao.korisnikExists(email))
            {
                System.out.println("usaooooooooooo");
                request.setAttribute("korisnikPostoji", true);
                request.getRequestDispatcher("index").forward(request, response);
            }
            else
            {
                Korisnik korisnik = new Korisnik();
                korisnik.setIme(ime);
                korisnik.setPrezime(prezime);
                korisnik.setEmail(email);
                korisnik.setLozinka(lozinka);
                int rows = korisnikDao.insertKorisnik(korisnik);
                if (rows == 1)
                {
                    request.setAttribute("novKorisnik", true);
                    request.getRequestDispatcher("index").forward(request, response);
                }
                else
                {
                    request.setAttribute("novKorisnikNeuspesno", true);
                    request.getRequestDispatcher("index").forward(request, response);
                }

            }

        }
        else
        {
            request.setAttribute("polja", true);
            request.getRequestDispatcher("index").forward(request, response);
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
