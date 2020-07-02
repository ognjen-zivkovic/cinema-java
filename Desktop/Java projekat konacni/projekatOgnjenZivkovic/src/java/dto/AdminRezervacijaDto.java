package dto;

import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class AdminRezervacijaDto
{

    private int rezervacijaId;
    private String status;
    private int korisnikId;
    private String email;
    private int projekcijaId;
    private int brojSale;
    private int bioskopId;
    private String bioskopGradNaziv;
    private String cena;
    private String vremePocetka;
    private int filmId;
    private String filmNaziv;
    private List<Integer> sedista;

    public String getBioskopGradNaziv()
    {
        return bioskopGradNaziv;
    }

    public void setBioskopGradNaziv(String bioskopGradNaziv)
    {
        this.bioskopGradNaziv = bioskopGradNaziv;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getProjekcijaId()
    {
        return projekcijaId;
    }

    public void setProjekcijaId(int projekcijaId)
    {
        this.projekcijaId = projekcijaId;
    }

    public int getBrojSale()
    {
        return brojSale;
    }

    public void setBrojSale(int brojSale)
    {
        this.brojSale = brojSale;
    }

    public int getBioskopId()
    {
        return bioskopId;
    }

    public void setBioskopId(int bioskopId)
    {
        this.bioskopId = bioskopId;
    }

    public String getCena()
    {
        return cena;
    }

    public void setCena(String cena)
    {
        this.cena = cena;
    }

    public String getVremePocetka()
    {
        return vremePocetka;
    }

    public void setVremePocetka(String vremePocetka)
    {
        this.vremePocetka = vremePocetka;
    }

    public int getFilmId()
    {
        return filmId;
    }

    public void setFilmId(int filmId)
    {
        this.filmId = filmId;
    }

    public String getFilmNaziv()
    {
        return filmNaziv;
    }

    public void setFilmNaziv(String filmNaziv)
    {
        this.filmNaziv = filmNaziv;
    }

    public List<Integer> getSedista()
    {
        return sedista;
    }

    public void setSedista(List<Integer> sedista)
    {
        this.sedista = sedista;
    }

}
