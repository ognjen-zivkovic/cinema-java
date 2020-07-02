

package daoimpl;

import beans.Projekciona_Sala;
import dao.DbConnection;
import dao.Projekciona_SalaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ognjen Živković
 */
public class Projekciona_SalaDaoImpl implements Projekciona_SalaDao{

    Statement stmt = DbConnection.vratiKonekciju();
    @Override
    public Projekciona_Sala getByIdAndBioskop(int brojSale, int bioskopId)
    {
        Projekciona_Sala projekciona_Sala = new Projekciona_Sala();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM projekciona_sala WHERE brojSale = "+brojSale+" AND bioskopId ="+bioskopId);
            if (rs.next())
            {
                projekciona_Sala.setBioskopId(rs.getInt(1));
                projekciona_Sala.setBrojSale(rs.getInt(2));
                projekciona_Sala.setUkupanBrojSedista(rs.getInt(3));
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return projekciona_Sala;
    }

    @Override
    public List<Integer> getByBioskop(int bioskopId)
    {
       
        List<Integer> sale = new ArrayList<Integer>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT brojSale FROM projekciona_sala WHERE bioskopId= "+bioskopId);
            while (rs.next())
            {
               sale.add(rs.getInt(1));
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return sale;
    }

}
