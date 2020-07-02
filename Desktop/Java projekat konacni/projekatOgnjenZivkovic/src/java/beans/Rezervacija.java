package beans;

/**
 *
 * @author Ognjen Živković
 */
public class Rezervacija
{

    private int rezervacijaId;
    private String status;
    private int korisnikId;
    private int projekcijaId;
    private String cena;

    public String getCena()
    {
        return cena;
    }

    public void setCena(String cena)
    {
        this.cena = cena;
    }
    
    

    public int getRezervacijaId()
    {
        return rezervacijaId;
    }

    public void setRezervacijaId(int rezervacijaId)
    {
        this.rezervacijaId = rezervacijaId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public int getKorisnikId()
    {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId)
    {
        this.korisnikId = korisnikId;
    }

    public int getProjekcijaId()
    {
        return projekcijaId;
    }

    public void setProjekcijaId(int projekcijaId)
    {
        this.projekcijaId = projekcijaId;
    }
    
    
}
