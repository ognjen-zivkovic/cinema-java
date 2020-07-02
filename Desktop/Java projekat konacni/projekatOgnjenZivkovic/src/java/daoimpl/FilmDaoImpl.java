

package daoimpl;

import beans.Film;
import dao.DbConnection;
import dao.FilmDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class FilmDaoImpl implements FilmDao
{

    Statement stmt = DbConnection.vratiKonekciju();

    @Override
    public List<Film> noviFilmovi()
    {
        List<Film> filmovi = new ArrayList<Film>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM film ORDER BY filmId DESC LIMIT 4");
            while (rs.next())
            {
                Film temp = new Film();
                temp.setFilmId(rs.getInt(1));
                temp.setNaziv(rs.getString(2));
                temp.setOpis(rs.getString(3));
                temp.setDuzinaTrajanja(rs.getString(4));
                temp.setSlika(rs.getString(5));
                temp.setTrailer(rs.getString(6));
                temp.setZanr(rs.getString(7));
                temp.setOcena(rs.getString(8));
                filmovi.add(temp);
                
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return filmovi;
    }

    @Override
    public List<Film> akcioniFilmovi()
    {
        List<Film> filmovi = new ArrayList<Film>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM film  WHERE zanr LIKE 'Akcija' ORDER BY filmId DESC");
            while (rs.next())
            {
                Film temp = new Film();
                temp.setFilmId(rs.getInt(1));
                temp.setNaziv(rs.getString(2));
                temp.setOpis(rs.getString(3));
                temp.setDuzinaTrajanja(rs.getString(4));
                temp.setSlika(rs.getString(5));
                temp.setTrailer(rs.getString(6));
                temp.setZanr(rs.getString(7));
                temp.setOcena(rs.getString(8));
                filmovi.add(temp);         
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return filmovi;
    }

    @Override
    public List<Film> hororFilmovi()
    {
       List<Film> filmovi = new ArrayList<Film>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM film  WHERE zanr LIKE 'Horor' ORDER BY filmId DESC");
            while (rs.next())
            {
                Film temp = new Film();
                temp.setFilmId(rs.getInt(1));
                temp.setNaziv(rs.getString(2));
                temp.setOpis(rs.getString(3));
                temp.setDuzinaTrajanja(rs.getString(4));
                temp.setSlika(rs.getString(5));
                temp.setTrailer(rs.getString(6));
                temp.setZanr(rs.getString(7));
                temp.setOcena(rs.getString(8));
                filmovi.add(temp);         
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return filmovi;
    }

    @Override
    public List<Film> animiraniFilmovi()
    {
        List<Film> filmovi = new ArrayList<Film>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM film  WHERE zanr LIKE 'Animirani' ORDER BY filmId DESC");
            while (rs.next())
            {
                Film temp = new Film();
                temp.setFilmId(rs.getInt(1));
                temp.setNaziv(rs.getString(2));
                temp.setOpis(rs.getString(3));
                temp.setDuzinaTrajanja(rs.getString(4));
                temp.setSlika(rs.getString(5));
                temp.setTrailer(rs.getString(6));
                temp.setZanr(rs.getString(7));
                temp.setOcena(rs.getString(8));
                filmovi.add(temp);         
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return filmovi;
    }

    @Override
    public List<Film> romanticniFilmovi()
    {
        List<Film> filmovi = new ArrayList<Film>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM film  WHERE zanr LIKE 'Romanticni' ORDER BY filmId DESC");
            while (rs.next())
            {
                Film temp = new Film();
                temp.setFilmId(rs.getInt(1));
                temp.setNaziv(rs.getString(2));
                temp.setOpis(rs.getString(3));
                temp.setDuzinaTrajanja(rs.getString(4));
                temp.setSlika(rs.getString(5));
                temp.setTrailer(rs.getString(6));
                temp.setZanr(rs.getString(7));
                temp.setOcena(rs.getString(8));
                filmovi.add(temp);         
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return filmovi;
    }

    @Override
    public Film getById(int id)
    {
       Film film = new Film();
       
       try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM film  WHERE filmId ="+id+"");
            if (rs.next())
            {
                film.setFilmId(rs.getInt(1));
                film.setNaziv(rs.getString(2));
                film.setOpis(rs.getString(3));
                film.setDuzinaTrajanja(rs.getString(4));
                film.setSlika(rs.getString(5));
                film.setTrailer(rs.getString(6));
                film.setZanr(rs.getString(7));
                film.setOcena(rs.getString(8));
                        
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return film;
       
    }

    @Override
    public List<Film> getAllFilmovi()
    {
        List<Film> filmovi = new ArrayList<Film>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM film");
            while (rs.next())
            {
                Film temp = new Film();
                temp.setFilmId(rs.getInt(1));
                temp.setNaziv(rs.getString(2));
                temp.setOpis(rs.getString(3));
                temp.setDuzinaTrajanja(rs.getString(4));
                temp.setSlika(rs.getString(5));
                temp.setTrailer(rs.getString(6));
                temp.setZanr(rs.getString(7));
                temp.setOcena(rs.getString(8));
                filmovi.add(temp);         
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return filmovi;
    }

    @Override
    public int insertIntoFilm(String naziv,String opis,String duzinaTrajanja,String slika,String trailer,String zanr,String ocena)
    {
      int rows = 0;
        try
        {
           rows = stmt.executeUpdate("INSERT INTO film (naziv, opis, duzinaTrajanja, slika, trailer, zanr, ocena) VALUES ('"+naziv+"','"+opis+"','"+duzinaTrajanja+"','"+slika+"','"+trailer+"','"+zanr+"','"+ocena+"')");
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int deleteFilm(int filmId)
    {
        int rows = 0;
        try
        {
           rows = stmt.executeUpdate("DELETE FROM film WHERE filmId = "+filmId);
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int updateFilm(int filmId, String naziv, String opis, String duzinaTrajanja, String trailer, String zanr, String ocena)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("UPDATE film SET naziv = '" + naziv + "',opis = '" + opis + "',duzinaTrajanja = '" + duzinaTrajanja + "', trailer = '" + trailer +"',zanr= '" + zanr + "', ocena = '" + ocena + "' WHERE filmId = " + filmId);
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int updateSlika(int filmId, String slika)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("UPDATE film SET slika = '"+slika+"' WHERE filmId = "+filmId);
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

}
