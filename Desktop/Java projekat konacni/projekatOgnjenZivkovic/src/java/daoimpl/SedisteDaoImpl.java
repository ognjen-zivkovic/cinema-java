

package daoimpl;

import beans.Projekcija;
import beans.Sediste;
import dao.DbConnection;
import dao.SedisteDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class SedisteDaoImpl implements SedisteDao{

    Statement stmt = DbConnection.vratiKonekciju();
    @Override
    public List<Sediste> getAllByBrojSaleAndBioskop(int brojSale, int bioskopId)
    {
          List<Sediste> sedista = new ArrayList<Sediste>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM sediste WHERE brojSale = "+brojSale+" AND bioskopId = "+bioskopId);
            while (rs.next())
            {
                Sediste temp = new Sediste();
                temp.setBrojSedista(rs.getInt(1));
                temp.setBrojSale(rs.getInt(2));
                temp.setBioskopId(rs.getInt(3));
                temp.setTipSedistaId(rs.getInt(4));
                sedista.add(temp);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return sedista;
    }

}
