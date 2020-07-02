package servlets;

import beans.Film;
import com.google.gson.Gson;
import dao.FilmDao;
import daoimpl.FilmDaoImpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Ognjen Živković
 */
@MultipartConfig
public class adminFilm extends HttpServlet
{

    private Gson gson = new Gson();

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
            out.println("<title>Servlet adminFilm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminFilm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        FilmDao filmDao = new FilmDaoImpl();
        List<Film> sviFilmovi = filmDao.getAllFilmovi();
        request.setAttribute("filmovi", sviFilmovi);
        request.getRequestDispatcher("adminFilm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        FilmDao filmDao = new FilmDaoImpl();
        if (request.getParameter("azuriranjeSlike") != null)
        {
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            Film temp = filmDao.getById(filmId);
            String slikaZaBrisanje = temp.getSlika();
            String savePath = System.getProperty("catalina.base") + File.separator + "webapps" + File.separator + "ROOT" + File.separator + "MovieAppResources" + File.separator + "movieCovers";
            // kreira direktorijum ukoliko ne postoji
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists())
            {
                fileSaveDir.mkdirs();
            }
            String slika = "";

            Part part = request.getPart("slika");
            String fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty())
            {
                fileName = new File(fileName).getName();
                part.write(savePath + File.separator + fileName);
            }

            slika = fileName;
            int rows = filmDao.updateSlika(filmId, slika);
            Path imagesPath = Paths.get(
                    System.getProperty("catalina.base") + File.separator + "webapps" + File.separator + "ROOT" + File.separator + "MovieAppResources" + File.separator + "movieCovers" + File.separator + ""
                    + temp.getSlika());

            try
            {
                Files.delete(imagesPath);

            } catch (IOException e)
            {

                e.printStackTrace();
            }
            
            if(rows >0)
            {
                 List<Film> sviFilmovi = filmDao.getAllFilmovi();
                request.setAttribute("slikaAzurirana", true);
                request.setAttribute("filmovi", sviFilmovi);
                request.getRequestDispatcher("adminFilm.jsp").forward(request, response);
            }
            else
            {
                List<Film> sviFilmovi = filmDao.getAllFilmovi();
                request.setAttribute("slikaNijeAzurirana", true);
                request.setAttribute("filmovi", sviFilmovi);
                request.getRequestDispatcher("adminFilm.jsp").forward(request, response);
            }

        }
        else if (request.getParameter("azuriranjeFilma") != null)
        {
            System.out.println("usao");
            int filmId = Integer.parseInt(request.getParameter("filmId"));
            String opis = request.getParameter("edit_opis");
            String duzinaTrajanja = request.getParameter("edit_duzinaTrajanja");
            String trejler = request.getParameter("edit_trejler");
            String zanr = request.getParameter("edit_zanr");
            String ocena = request.getParameter("edit_ocena");
            String naziv = request.getParameter("edit_naziv");
            int rows = 0;
            rows = filmDao.updateFilm(filmId, naziv, opis, duzinaTrajanja, trejler, zanr, ocena);
            if (rows > 0)
            {
                List<Film> sviFilmovi = filmDao.getAllFilmovi();
                request.setAttribute("uspesnoAzurirano", true);
                request.setAttribute("filmovi", sviFilmovi);
                request.getRequestDispatcher("adminFilm.jsp").forward(request, response);
            }
            else
            {
                List<Film> sviFilmovi = filmDao.getAllFilmovi();
                request.setAttribute("neuspesnoAzurirano", true);
                request.setAttribute("filmovi", sviFilmovi);
                request.getRequestDispatcher("adminFilm.jsp").forward(request, response);
            }
        }

        else if (request.getParameter("popuniAzuriranje") != null)
        {
            response.setContentType("application/json");
            response.setContentType("text/html;charset=UTF-8");
            Film temp = filmDao.getById(Integer.parseInt(request.getParameter("popuniAzuriranje")));

            String json = this.gson.toJson(temp);
            PrintWriter out = response.getWriter();

            out.print(json);
            out.flush();
        }

        else if (request.getParameter("brisanjeFilmId") != null)
        {
            int rows = 0;
            int filmId = Integer.parseInt(request.getParameter("brisanjeFilmId"));
            Film temp = filmDao.getById(filmId);
            rows = filmDao.deleteFilm(filmId);
            Path imagesPath = Paths.get(
                    System.getProperty("catalina.base") + File.separator + "webapps" + File.separator + "ROOT" + File.separator + "MovieAppResources" + File.separator + "movieCovers" + File.separator + ""
                    + temp.getSlika());

            try
            {
                Files.delete(imagesPath);

            } catch (IOException e)
            {

                e.printStackTrace();
            }
            if (rows > 0)
            {
                response.setContentType("text/plain");
                response.getWriter().println("uspesno");
            }
            else
            {
                response.setContentType("text/plain");
                response.getWriter().println("neuspesno");
            }
        }

        else if (request.getParameter("naziv") != null)
        {
            String opis = request.getParameter("opis");
            String duzinaTrajanja = request.getParameter("duzinaTrajanja");
            String trejler = request.getParameter("trejler");
            String zanr = request.getParameter("zanr");
            String ocena = request.getParameter("ocena");
            String naziv = request.getParameter("naziv");

            String savePath = System.getProperty("catalina.base") + File.separator + "webapps" + File.separator + "ROOT" + File.separator + "MovieAppResources" + File.separator + "movieCovers";

            // kreira direktorijum ukoliko ne postoji
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists())
            {
                fileSaveDir.mkdirs();
            }
            String slika = "";

            Part part = request.getPart("slika");
            String fileName = extractFileName(part);
            if (fileName != null && !fileName.isEmpty())
            {
                fileName = new File(fileName).getName();
                part.write(savePath + File.separator + fileName);
            }

            slika = fileName;

            int rows = filmDao.insertIntoFilm(naziv, opis, duzinaTrajanja, slika, trejler, zanr, ocena);
            if (rows == 1)
            {
                List<Film> sviFilmovi = filmDao.getAllFilmovi();
                request.setAttribute("uspesnoDodato", true);
                request.setAttribute("filmovi", sviFilmovi);
                request.getRequestDispatcher("adminFilm.jsp").forward(request, response);

            }
            else
            {
                List<Film> sviFilmovi = filmDao.getAllFilmovi();
                request.setAttribute("neuspesnoDodato", true);
                request.setAttribute("filmovi", sviFilmovi);
                request.getRequestDispatcher("adminFilm.jsp").forward(request, response);
            }
        }
        else
        {
            List<Film> sviFilmovi = filmDao.getAllFilmovi();
            request.setAttribute("filmovi", sviFilmovi);
            request.getRequestDispatcher("adminFilm.jsp").forward(request, response);
        }

    }

    /**
     *
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part)
    {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items)
        {
            if (s.trim().startsWith("filename"))
            {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
