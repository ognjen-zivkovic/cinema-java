package daoimpl;

import beans.Projekcija;
import beans.Rezervacija;
import dao.DbConnection;
import dao.RezervacijaDao;
import dto.AdminRezervacijaDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class RezervacijaDaoImpl implements RezervacijaDao
{

    Statement stmt = DbConnection.vratiKonekciju();

    @Override
    public int insertIntoRezervacija(String status, int korisnikId, int projekcijaId, String cena)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("INSERT INTO rezervacija(status,korisnikId,projekcijaId,cena) VALUES ('" + status + "'," + korisnikId + "," + projekcijaId + ",'"+cena+"')");

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int getMaxId()
    {
        int rows = 0;
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT MAX(rezervacijaId) FROM rezervacija");
            if (rs.next())
            {
                rows = rs.getInt(1);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int deleteByKorisnik(int korisnikId)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("DELETE FROM rezervacija WHERE korisnikId = "+korisnikId);

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public List<Rezervacija> getAll()
    {
       List<Rezervacija> rezervacije = new ArrayList<Rezervacija>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM rezervacija");
            while(rs.next())
            {
                Rezervacija temp = new Rezervacija();
                temp.setRezervacijaId(rs.getInt(1));
                temp.setStatus(rs.getString(2));
                temp.setKorisnikId(rs.getInt(3));
                temp.setProjekcijaId(rs.getInt(4));
                rezervacije.add(temp);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rezervacije;
    }

    @Override
    public List<AdminRezervacijaDto> displayRezervacije()
    {
        List<AdminRezervacijaDto> rezervacijeZaPrikaz = new ArrayList<AdminRezervacijaDto>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT r.rezervacijaId,r.status,r.korisnikId,r.projekcijaId,r.cena,k.email,p.brojSale,p.bioskopId,p.vremePocetka,p.filmId,f.naziv, g.naziv\n" +
"FROM rezervacija r JOIN korisnik k ON k.korisnikId=r.korisnikId JOIN projekcija p ON p.projekcijaId=r.projekcijaId JOIN film f ON f.filmId=p.filmId JOIN bioskop bi ON bi.bioskopId = p.bioskopId JOIN grad g ON g.gradId = bi.gradId");
            while (rs.next())
            {
                AdminRezervacijaDto temp = new AdminRezervacijaDto();
                temp.setRezervacijaId(rs.getInt(1));
                temp.setStatus(rs.getString(2));
                temp.setKorisnikId(rs.getInt(3));
                temp.setProjekcijaId(rs.getInt(4));
                temp.setCena(rs.getString(5));
                temp.setEmail(rs.getString(6));
                temp.setBrojSale(rs.getInt(7));
                temp.setBioskopId(rs.getInt(8));
                temp.setVremePocetka(rs.getString(9));
                temp.setFilmId(rs.getInt(10));
                temp.setFilmNaziv(rs.getString(11));
                temp.setBioskopGradNaziv(rs.getString(12));
                rezervacijeZaPrikaz.add(temp);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rezervacijeZaPrikaz;
    }

    @Override
    public List<Integer> sedistaByRezervacija(int rezervacijaId)
    {
       List<Integer> sedista = new ArrayList<Integer>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT brojSedista FROM `sediste_rezervisano` WHERE rezervacijaId = "+rezervacijaId+"");
            while (rs.next())
            {
               sedista.add(rs.getInt(1));
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return sedista;
    }

    @Override
    public int deleteById(int rezervacijaId)
    {
       int rows = 0;
        try
        {
            rows = stmt.executeUpdate("DELETE FROM rezervacija WHERE rezervacijaId = "+rezervacijaId);
        
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int promeniStatus(int rezervacijaId, String status)
    {
         int rows = 0;
        try
        {
            rows = stmt.executeUpdate("UPDATE rezervacija SET status = '"+status+"' WHERE rezervacijaId = "+rezervacijaId);
        
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

}
