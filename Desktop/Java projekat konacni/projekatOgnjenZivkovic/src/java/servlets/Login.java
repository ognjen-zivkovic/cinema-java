
package servlets;

import beans.Klub;
import beans.Korisnik;
import dao.KlubDao;
import dao.KorisnikDao;
import daoimpl.KlubDaoImpl;
import daoimpl.KorisnikDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ognjen Živković
 */
public class Login extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String lozinka = request.getParameter("lozinka");
        if(email != null && !email.isEmpty() && lozinka != null && !lozinka.isEmpty())
        {
            KorisnikDao dao = new KorisnikDaoImpl();
            Korisnik uBazi = dao.korisnikAuthentication(email, lozinka);
            if (uBazi != null)
            {
                HttpSession sesija = request.getSession();
                Korisnik temp = dao.getById(uBazi.getKorisnikId());
                KlubDao klubDao = new KlubDaoImpl();
                Klub klub = klubDao.getById(temp.getKlubId());
                sesija.setAttribute("korisnik_klub", klub);
                sesija.setAttribute("korisnik", uBazi);
                request.setAttribute("uspesanLogin", true);
                if (uBazi.getNivo() == 2)
                {
                    request.getRequestDispatcher("index").forward(request, response);
                }
                else
                {
                    //admin
                    request.getRequestDispatcher("adminFilm").forward(request, response);
                }

            }
            else
            {
                request.setAttribute("loginFormaNemaKorisnika", true);
                request.getRequestDispatcher("index").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("loginFormaPogresanUnos", true);
            request.getRequestDispatcher("index").forward(request, response);
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
