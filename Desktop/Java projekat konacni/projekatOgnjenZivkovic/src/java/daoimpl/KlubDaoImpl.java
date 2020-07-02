

package daoimpl;


import beans.Klub;
import dao.DbConnection;
import dao.KlubDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Ognjen Živković
 */
public class KlubDaoImpl implements KlubDao{

     Statement stmt = DbConnection.vratiKonekciju();
    @Override
    public Klub getById(int klubId)
    {
        Klub klub = new Klub();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM klub WHERE klubId = "+klubId);
            if (rs.next())
            {
                klub.setKlubId(rs.getInt(1));
                klub.setNaziv(rs.getString(2));
                klub.setPopust(rs.getInt(3));  
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return klub;
    }

}
