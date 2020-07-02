
package servlets;

import beans.Film;
import beans.Korisnik;
import dao.KorisnikDao;
import dao.RezervacijaDao;
import daoimpl.KorisnikDaoImpl;
import daoimpl.RezervacijaDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ognjen Živković
 */
public class adminKorisnik extends HttpServlet {
    KorisnikDao korisnikDao = new KorisnikDaoImpl();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminKorisnik</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminKorisnik at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Korisnik> sviKorisnici = korisnikDao.getAll();
        request.setAttribute("korisnici", sviKorisnici);
        request.getRequestDispatcher("adminKorisnik.jsp").forward(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        if(request.getParameter("korisnikId") != null)
        {
            int korisnikId = Integer.parseInt(request.getParameter("korisnikId"));
            int rows = korisnikDao.deleteKorisnik(korisnikId);
            if(rows > 0)
            {
                request.setAttribute("korisnikObrisan", true);
            }
            else
            {
                request.setAttribute("greska", true);
            }
        }
        List<Korisnik> sviKorisnici = korisnikDao.getAll();
        request.setAttribute("korisnici", sviKorisnici);
        request.getRequestDispatcher("adminKorisnik.jsp").forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
