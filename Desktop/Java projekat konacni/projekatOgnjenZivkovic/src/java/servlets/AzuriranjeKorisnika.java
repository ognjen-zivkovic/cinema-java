
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
public class AzuriranjeKorisnika extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        Korisnik kor = (Korisnik) request.getSession().getAttribute("korisnik");
        int idKorisnika = kor.getKorisnikId();
        
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String email = request.getParameter("email");
        String lozinka = request.getParameter("trenutnaLozinka");
        if (kor.getLozinka().equals(lozinka))
        {
            Korisnik korisnik = new Korisnik();
            korisnik.setKorisnikId(idKorisnika);
            korisnik.setIme(ime);
            korisnik.setPrezime(prezime);
            korisnik.setEmail(email);
            korisnik.setLozinka(request.getParameter("lozinka"));
            korisnik.setBrojPoena(-1);
            korisnik.setNivo(-1);
            KorisnikDao dao = new KorisnikDaoImpl();
            int rows = dao.updateKorisnik(korisnik);
            if (rows > 0)
            {
                request.setAttribute("uspesnoAzurirano", 1);
                request.getSession().setAttribute("korisnik", dao.getById(idKorisnika));
                request.getRequestDispatcher("korisnik_profil.jsp").forward(request, response);
            }
            else
            {
                 request.setAttribute("greska", 1);
                request.getRequestDispatcher("korisnik_profil.jsp").forward(request, response);
            }

        }
        else
        {
            request.setAttribute("pogresnaLozinka", 1);
            request.getRequestDispatcher("korisnik_profil.jsp").forward(request, response);
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
