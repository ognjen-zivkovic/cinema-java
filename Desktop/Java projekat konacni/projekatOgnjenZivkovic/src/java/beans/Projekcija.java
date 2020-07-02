package beans;

/**
 *
 * @author Ognjen Živković
 */
public class Projekcija
{

    private int projekcijaId;
    private String vremePocetka;
    private double cena;
    private int bioskopId;
    private int brojSale;
    private int filmId;

    public int getProjekcijaId()
    {
        return projekcijaId;
    }

    public void setProjekcijaId(int projekcijaId)
    {
        this.projekcijaId = projekcijaId;
    }

    public String getVremePocetka()
    {
        return vremePocetka;
    }

    public void setVremePocetka(String vremePocetka)
    {
        this.vremePocetka = vremePocetka;
    }

    public double getCena()
    {
        return cena;
    }

    public void setCena(double cena)
    {
        this.cena = cena;
    }

    public int getBioskopId()
    {
        return bioskopId;
    }

    public void setBioskopId(int bioskopId)
    {
        this.bioskopId = bioskopId;
    }

    public int getBrojSale()
    {
        return brojSale;
    }

    public void setBrojSale(int brojSale)
    {
        this.brojSale = brojSale;
    }

    public int getFilmId()
    {
        return filmId;
    }

    public void setFilmId(int filmId)
    {
        this.filmId = filmId;
    }
    
    
    
}
