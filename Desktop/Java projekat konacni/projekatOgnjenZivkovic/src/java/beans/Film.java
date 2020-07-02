package beans;

/**
 *
 * @author Ognjen Živković
 */
public class Film
{

    private int filmId;
    private String naziv;
    private String opis;
    private String duzinaTrajanja;
    private String slika;
    private String trailer;
    private String zanr;
    private String ocena;

    public String getOcena()
    {
        return ocena;
    }

    public void setOcena(String ocena)
    {
        this.ocena = ocena;
    }
    

    public String getZanr()
    {
        return zanr;
    }

    public void setZanr(String zanr)
    {
        this.zanr = zanr;
    }

    
    
    public int getFilmId()
    {
        return filmId;
    }

    public void setFilmId(int filmId)
    {
        this.filmId = filmId;
    }

    public String getNaziv()
    {
        return naziv;
    }

    public void setNaziv(String naziv)
    {
        this.naziv = naziv;
    }

    public String getOpis()
    {
        return opis;
    }

    public void setOpis(String opis)
    {
        this.opis = opis;
    }

    public String getDuzinaTrajanja()
    {
        return duzinaTrajanja;
    }

    public void setDuzinaTrajanja(String duzinaTrajanja)
    {
        this.duzinaTrajanja = duzinaTrajanja;
    }

    public String getSlika()
    {
        return slika;
    }

    public void setSlika(String slika)
    {
        this.slika = slika;
    }

    public String getTrailer()
    {
        return trailer;
    }

    public void setTrailer(String trailer)
    {
        this.trailer = trailer;
    }
    
    
}
