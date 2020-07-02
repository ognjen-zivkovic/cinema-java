
package servlets;

import beans.Bioskop;
import beans.Grad;
import beans.Projekcija;
import dao.BioskopDao;
import dao.FilmDao;
import dao.GradDao;
import dao.ProjekcijaDao;
import daoimpl.BioskopDaoImpl;
import daoimpl.FilmDaoImpl;
import daoimpl.GradDaoImpl;
import daoimpl.ProjekcijaDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ognjen Živković
 */
public class detaljiFilma extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet detaljiFilma</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet detaljiFilma at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int filmId=Integer.parseInt(request.getParameter("filmId"));
        FilmDao dao = new FilmDaoImpl();
        request.setAttribute("film", dao.getById(filmId));
        BioskopDao daoBioskop = new BioskopDaoImpl();
        GradDao daoGrad = new GradDaoImpl();
        List<Bioskop> bioskopi = new ArrayList<Bioskop>();
        bioskopi=daoBioskop.getAll();
        for(Bioskop b:bioskopi)
        {
            Grad temp = daoGrad.getById(b.getGradId());
            b.setGradNaziv(temp.getNaziv());
        }
        request.setAttribute("bioskopi",bioskopi);
        request.getRequestDispatcher("detaljiFilma.jsp").forward(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
     
        if(request.getParameter("rezervacijaBtn") != null)
        {
            request.setAttribute("projekcijaId", request.getParameter("projekcija"));
            request.setAttribute("filmId", request.getParameter("filmId"));
            request.getRequestDispatcher("rezervacijaFilma").forward(request, response);
        }
        else
        {
            ////////////////////
        int filmId = Integer.parseInt(request.getParameter("filmId"));
        FilmDao dao = new FilmDaoImpl();
        request.setAttribute("film", dao.getById(filmId));
        BioskopDao daoBioskop = new BioskopDaoImpl();
        GradDao daoGrad = new GradDaoImpl();
        List<Bioskop> bioskopi = new ArrayList<Bioskop>();
        bioskopi=daoBioskop.getAll();
        for(Bioskop b:bioskopi)
        {
            Grad temp = daoGrad.getById(b.getGradId());
            b.setGradNaziv(temp.getNaziv());
        }
        
        ////
         int bioskopId = Integer.parseInt(request.getParameter("bioskop"));
        String datum = request.getParameter("datumProjekcije");
        ProjekcijaDao projekcijaDao = new ProjekcijaDaoImpl();
        List<Projekcija> projekcije = projekcijaDao.getAllByMovieAndTheater(bioskopId, filmId, datum);
        
        if(projekcije == null)
            request.setAttribute("nemaProjekcije", true);
        request.setAttribute("projekcije", projekcije);
        //////
        request.setAttribute("izabranBioskop", bioskopId);
        request.setAttribute("izabranDatum", datum);
        request.setAttribute("bioskopi", bioskopi);
        request.getRequestDispatcher("detaljiFilma.jsp").forward(request, response);
        ///////////////////      
        }   
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
