package beans;

/**
 *
 * @author Ognjen Živković
 */
public class Bioskop
{

    private int bioskopId;
    private String adresa;
    private String gradNaziv;
    private int gradId;

    public String getGradNaziv()
    {
        return gradNaziv;
    }

    public void setGradNaziv(String gradNaziv)
    {
        this.gradNaziv = gradNaziv;
    }

    public int getGradId()
    {
        return gradId;
    }

    public void setGradId(int gradId)
    {
        this.gradId = gradId;
    }
    
    
    
    public int getBioskopId()
    {
        return bioskopId;
    }

    public void setBioskopId(int bioskopId)
    {
        this.bioskopId = bioskopId;
    }

    public String getAdresa()
    {
        return adresa;
    }

    public void setAdresa(String adresa)
    {
        this.adresa = adresa;
    }

   
    
    
}
