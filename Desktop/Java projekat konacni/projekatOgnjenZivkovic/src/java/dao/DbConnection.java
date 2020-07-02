package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ognjen Živković
 */
public class DbConnection
{

    public static Statement vratiKonekciju()
    {
        Statement stmt = null;
        try
        {
            String dbUrl = "jdbc:mysql://localhost:3306/projekatbioskop";
            String user = "root";
            String pass = "";

            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(dbUrl, user, pass);
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        } catch (SQLException s)
        {
            System.out.println(s.getMessage());
        }
        return stmt;
    }

}
