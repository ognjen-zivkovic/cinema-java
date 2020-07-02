package daoimpl;

import beans.Bioskop;
import beans.Film;
import dao.BioskopDao;
import dao.DbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ognjen Živković
 */
public class BioskopDaoImpl implements BioskopDao
{

    Statement stmt = DbConnection.vratiKonekciju();

    @Override
    public List<Bioskop> getAll()
    {
        List<Bioskop> bioskopi = new ArrayList<Bioskop>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT b.bioskopId,b.adresa,b.gradId,g.naziv FROM bioskop b JOIN grad g ON g.gradId=b.gradId");
            while (rs.next())
            {
                Bioskop temp = new Bioskop();
                temp.setBioskopId(rs.getInt(1));
                temp.setAdresa(rs.getString(2));
                temp.setGradId(rs.getInt(3));
                temp.setGradNaziv(rs.getString(4));
                bioskopi.add(temp);
            }

        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return bioskopi;
    }

}
