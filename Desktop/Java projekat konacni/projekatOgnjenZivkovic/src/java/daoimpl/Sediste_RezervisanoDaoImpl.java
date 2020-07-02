package daoimpl;

import beans.Bioskop;
import beans.Sediste;
import beans.Sediste_Rezervisano;
import dao.DbConnection;
import dao.Sediste_RezervisanoDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class Sediste_RezervisanoDaoImpl implements Sediste_RezervisanoDao
{

    Statement stmt = DbConnection.vratiKonekciju();

    @Override
    public List<Sediste_Rezervisano> getAllByProjekcija(int projekcijaId)
    {
        List<Sediste_Rezervisano> sedista = new ArrayList<Sediste_Rezervisano>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM sediste_rezervisano WHERE projekcijaId = " + projekcijaId);
            while (rs.next())
            {
                Sediste_Rezervisano temp = new Sediste_Rezervisano();
                temp.setRezervisanoSedisteId(rs.getInt(1));
                temp.setRezervacijaId(rs.getInt(2));
                temp.setProjekcijaId(rs.getInt(3));
                temp.setBrojSedista(rs.getInt(4));
                temp.setBrojSale(rs.getInt(5));
                temp.setBioskopId(rs.getInt(6));
                sedista.add(temp);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return sedista;
    }

    @Override
    public int insertIntoSedisteRezervisano(int rezervacijaId, int projekcijaId, int brojSedista, int brojSale, int bioskopId)
    {
       int rows = 0;
        try
        {
            rows = stmt.executeUpdate("INSERT INTO sediste_rezervisano (rezervacijaId, projekcijaId, brojSedista, brojSale, bioskopId) VALUES ("+rezervacijaId+","+projekcijaId+","+brojSedista+","+brojSale+","+bioskopId+")");
       
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return rows;
    }

}
