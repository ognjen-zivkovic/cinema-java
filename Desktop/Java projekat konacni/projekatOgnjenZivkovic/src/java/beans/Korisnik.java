package beans;

import java.sql.Timestamp;

/**
 *
 * @author Ognjen Živković
 */
public class Korisnik
{

    private int korisnikId;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;
    private int brojPoena=0;
    private int nivo=2;
    private String nalogNapravljen;
    private Integer klubId=-1;

    
    public void setNalogNapravljen(String nalogNapravljen)
    {
        this.nalogNapravljen = nalogNapravljen;
    }
    
    public String getNalogNapravljen()
    {
        return this.nalogNapravljen;
    }
    
    public int getKorisnikId()
    {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId)
    {
        this.korisnikId = korisnikId;
    }

    public String getIme()
    {
        return ime;
    }

    public void setIme(String ime)
    {
        this.ime = ime;
    }

    public String getPrezime()
    {
        return prezime;
    }

    public void setPrezime(String prezime)
    {
        this.prezime = prezime;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLozinka()
    {
        return lozinka;
    }

    public void setLozinka(String lozinka)
    {
        this.lozinka = lozinka;
    }

    public int getBrojPoena()
    {
        return brojPoena;
    }

    public void setBrojPoena(int brojPoena)
    {
        this.brojPoena = brojPoena;
    }

    public int getNivo()
    {
        return nivo;
    }

    public void setNivo(int nivo)
    {
        this.nivo = nivo;
    }

    public int getKlubId()
    {
        return klubId;
    }

    public void setKlubId(int klubId)
    {
        this.klubId = klubId;
    }

}
