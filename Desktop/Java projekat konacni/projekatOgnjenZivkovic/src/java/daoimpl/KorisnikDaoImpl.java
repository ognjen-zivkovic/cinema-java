package daoimpl;

import beans.Korisnik;
import dao.DbConnection;
import dao.KorisnikDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ognjen Živković
 */
public class KorisnikDaoImpl implements KorisnikDao
{

    Statement stmt = DbConnection.vratiKonekciju();

    @Override
    public boolean korisnikExists(String email)
    {
        try
        {
            ResultSet rs = stmt.executeQuery("select COUNT(*) from korisnik WHERE email LIKE '" + email + "'");
            if (rs.next())
            {
                if (rs.getInt(1) == 0)
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    @Override
    public int insertKorisnik(Korisnik korisnik)
    {
        try
        {
            int rows = stmt.executeUpdate("INSERT INTO korisnik (ime,prezime,email,lozinka,brojPoena,nivo) VALUES ('" + korisnik.getIme() + "','" + korisnik.getPrezime() + "','" + korisnik.getEmail() + "','" + korisnik.getLozinka() + "'," + korisnik.getBrojPoena() + "," + korisnik.getNivo() + ")");
            if (rows > 0)
            {
                return 1;
            }
            else
            {
                return 0;
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public Korisnik korisnikAuthentication(String email, String lozinka)
    {
        Korisnik korisnik = null;
        try
        {
            ResultSet rs = stmt.executeQuery("select * FROM korisnik WHERE email LIKE '" + email + "' AND lozinka LIKE '" + lozinka + "'");
            if (rs.next())
            {
                korisnik = new Korisnik();
                korisnik.setKorisnikId(rs.getInt(1));
                korisnik.setIme(rs.getString(2));
                korisnik.setPrezime(rs.getString(3));
                korisnik.setEmail(rs.getString(4));
                korisnik.setLozinka(rs.getString(5));
                korisnik.setBrojPoena(rs.getInt(6));
                korisnik.setNivo(rs.getInt(7));
                korisnik.setNalogNapravljen(new SimpleDateFormat("dd/MM/yyyy").format(rs.getTimestamp(8)));
                korisnik.setKlubId(rs.getInt(9));
                return korisnik;
            }
            else
            {
                return korisnik;
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return korisnik;
    }

    @Override
    public int updateKorisnik(Korisnik korisnik)
    {
        int brojPoena, nivo;
        if (korisnik.getBrojPoena() == -1)
        {
            brojPoena = 0;
        }
        else
        {
            brojPoena = korisnik.getBrojPoena();
        }

        if (korisnik.getNivo() == -1)
        {
            nivo = 2;
        }
        else
        {
            nivo = korisnik.getNivo();
        }
        try
        {
            int rs = stmt.executeUpdate("UPDATE korisnik SET ime = '"+korisnik.getIme()+"',prezime='"+korisnik.getPrezime()+"',email='"+korisnik.getEmail()+"',lozinka='"+korisnik.getLozinka()+"',brojPoena="+brojPoena+",nivo="+nivo+" WHERE korisnikId ="+korisnik.getKorisnikId()+"");
            return rs;

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public Korisnik getById(int id)
    {
        Korisnik korisnik = null;
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM korisnik WHERE korisnikId="+id+"");
            if(rs.next())
            {
                korisnik = new Korisnik();
                korisnik.setKorisnikId(rs.getInt(1));
                korisnik.setIme(rs.getString(2));
                korisnik.setPrezime(rs.getString(3));
                korisnik.setEmail(rs.getString(4));
                korisnik.setLozinka(rs.getString(5));
                korisnik.setBrojPoena(rs.getInt(6));
                korisnik.setNivo(rs.getInt(7));
                korisnik.setNalogNapravljen(new SimpleDateFormat("dd/MM/yyyy").format(rs.getTimestamp(8)));
                korisnik.setKlubId(rs.getInt(9));
                return korisnik;
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Korisnik> getAll()
    {
        List<Korisnik> korisnici = new ArrayList<>();
         try
        {
            ResultSet rs = stmt.executeQuery("select * FROM korisnik");
            while (rs.next())
            {
               Korisnik temp = new Korisnik();
               temp.setKorisnikId(rs.getInt(1));
               temp.setIme(rs.getString(2));
               temp.setPrezime(rs.getString(3));
               temp.setEmail(rs.getString(4));
               temp.setLozinka(rs.getString(5));
               temp.setBrojPoena(rs.getInt(6));
               korisnici.add(temp);
            }
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return korisnici;
    }

    @Override
    public int deleteKorisnik(int korisnikId)
    {
        int rows = 0;
       try
        {
            rows = stmt.executeUpdate("DELETE FROM korisnik WHERE korisnikId = "+korisnikId);
          

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int updatePoeni(int korisnikId, int brojPoena)
    {
        int rows = 0;
        int poeni = 0;
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT brojPoena FROM korisnik WHERE korisnikId = " + korisnikId);
            if (rs.next())
            {
                poeni = rs.getInt(1);
            }
            poeni += brojPoena;
            rows = stmt.executeUpdate("UPDATE korisnik SET brojPoena = " + poeni + " WHERE korisnikId = " + korisnikId);

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int resetPoeni(int korisnikId)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("UPDATE korisnik SET brojPoena = 0 WHERE korisnikId = " + korisnikId);
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    @Override
    public int setKlub(int klubId, int korisnikId)
    {
        int rows = 0;
        try
        {
            rows = stmt.executeUpdate("UPDATE korisnik SET klubId = "+klubId+" WHERE korisnikId = " + korisnikId);
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

    
}
