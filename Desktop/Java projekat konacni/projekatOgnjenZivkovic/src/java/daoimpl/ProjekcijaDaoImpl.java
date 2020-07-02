package daoimpl;

import beans.Bioskop;
import beans.Projekcija;
import dao.DbConnection;
import dao.ProjekcijaDao;
import dto.AdminProjekcijaDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class ProjekcijaDaoImpl implements ProjekcijaDao
{

    Statement stmt = DbConnection.vratiKonekciju();

    @Override
    public List<Projekcija> getAllByMovieAndTheater(int bioskopId, int filmId, String datumProjekcije)
    {
        List<Projekcija> projekcije = null;
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM projekcija WHERE bioskopId=" + bioskopId + " AND filmId=" + filmId + " AND DATE(vremePocetka)='" + datumProjekcije + "'");
            while (rs.next())
            {
                if(projekcije == null)
                projekcije = new ArrayList<Projekcija>();
                Projekcija temp = new Projekcija();
                temp.setProjekcijaId(rs.getInt(1));
                temp.setVremePocetka(rs.getString(2));
                temp.setCena(rs.getDouble(3));
                temp.setBioskopId(rs.getInt(4));
                temp.setBrojSale(rs.getInt(5));
                temp.setFilmId(rs.getInt(6));
                projekcije.add(temp);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return projekcije;
    }

    @Override
    public Projekcija getById(int id)
    {
        Projekcija projekcija = new Projekcija();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM projekcija WHERE projekcijaId = " + id);
            if (rs.next())
            {

                projekcija.setProjekcijaId(rs.getInt(1));
                projekcija.setVremePocetka(rs.getString(2));
                projekcija.setCena(rs.getDouble(3));
                projekcija.setBioskopId(rs.getInt(4));
                projekcija.setBrojSale(rs.getInt(5));
                projekcija.setFilmId(rs.getInt(6));
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return projekcija;
    }

    @Override
    public List<AdminProjekcijaDto> getAllByBioskop(int bioskopId)
    {
        List<AdminProjekcijaDto> projekcije = new ArrayList<AdminProjekcijaDto>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT p.projekcijaId,p.vremePocetka,p.cena,p.bioskopId,p.brojSale,p.filmId,f.naziv  FROM projekcija p JOIN film f ON f.filmId=p.filmId WHERE p.bioskopId=" + bioskopId + "");
            while (rs.next())
            {
                AdminProjekcijaDto temp = new AdminProjekcijaDto();
                temp.setProjekcijaId(rs.getInt(1));
                temp.setVremePocetka(rs.getString(2));
                temp.setCena(rs.getDouble(3));
                temp.setBioskopId(rs.getInt(4));
                temp.setBrojSale(rs.getInt(5));
                temp.setFilmId(rs.getInt(6));
                temp.setNazivFilma(rs.getString(7));
                projekcije.add(temp);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return projekcije;
    }

    @Override
    public int deleteById(int projekcijaId)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("DELETE FROM projekcija WHERE projekcijaId = " + projekcijaId);

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int addProjekcija(int filmId, int bioskopId, int brojSale, double cena, String vremePocetka)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("INSERT INTO projekcija(vremePocetka, cena, bioskopId, brojSale,filmId) VALUES ('"+vremePocetka+"',"+cena+","+bioskopId+","+brojSale+","+filmId+")");

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

}
