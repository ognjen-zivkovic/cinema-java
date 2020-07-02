

package daoimpl;

import beans.Bioskop;
import beans.Grad;
import dao.DbConnection;
import dao.GradDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class GradDaoImpl implements GradDao{

    Statement stmt = DbConnection.vratiKonekciju();
    @Override
    public Grad getById(int id)
    {
         Grad temp = new Grad();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM grad WHERE gradId="+id+"");
            if (rs.next())
            {
                temp.setGradId(rs.getInt(1));
                temp.setNaziv(rs.getString(2));
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return temp;
    }

}
