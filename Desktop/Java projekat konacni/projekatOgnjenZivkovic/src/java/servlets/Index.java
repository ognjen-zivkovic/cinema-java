package servlets;

import beans.Korisnik;
import dao.FilmDao;
import daoimpl.FilmDaoImpl;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ognjen Živković
 */
public class Index extends HttpServlet
{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        FilmDao dao = new FilmDaoImpl();
        request.setAttribute("noviFilmovi", dao.noviFilmovi());
        request.setAttribute("akcioniFilmovi", dao.akcioniFilmovi());
        request.setAttribute("hororFilmovi", dao.hororFilmovi());
        request.setAttribute("animiraniFilmovi", dao.animiraniFilmovi());
        request.setAttribute("romanticniFilmovi", dao.romanticniFilmovi());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        FilmDao dao = new FilmDaoImpl();
        request.setAttribute("noviFilmovi", dao.noviFilmovi());
        request.setAttribute("akcioniFilmovi", dao.akcioniFilmovi());
        request.setAttribute("hororFilmovi", dao.hororFilmovi());
        request.setAttribute("animiraniFilmovi", dao.animiraniFilmovi());
        request.setAttribute("romanticniFilmovi", dao.romanticniFilmovi());
        Korisnik korisnik = null;
        if (request.getSession().getAttribute("korisnik") != null)
        {
            korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
        }
        if (korisnik != null)
        {
            if (korisnik.getNivo() == 1)
            {
                response.sendRedirect("adminFilm");
            }
            else
            {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        else
        {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
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
