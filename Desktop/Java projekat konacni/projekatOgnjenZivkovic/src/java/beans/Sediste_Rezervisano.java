package beans;

/**
 *
 * @author Ognjen Živković
 */
public class Sediste_Rezervisano
{

    private int rezervisanoSedisteId;
    private int rezervacijaId;
    private int projekcijaId;
    private int brojSedista;
    private int brojSale;
    private int bioskopId;

    public int getRezervisanoSedisteId()
    {
        return rezervisanoSedisteId;
    }

    public void setRezervisanoSedisteId(int rezervisanoSedisteId)
    {
        this.rezervisanoSedisteId = rezervisanoSedisteId;
    }

    public int getRezervacijaId()
    {
        return rezervacijaId;
    }

    public void setRezervacijaId(int rezervacijaId)
    {
        this.rezervacijaId = rezervacijaId;
    }

    public int getProjekcijaId()
    {
        return projekcijaId;
    }

    public void setProjekcijaId(int projekcijaId)
    {
        this.projekcijaId = projekcijaId;
    }

    public int getBrojSedista()
    {
        return brojSedista;
    }

    public void setBrojSedista(int brojSedista)
    {
        this.brojSedista = brojSedista;
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
    
    
}
