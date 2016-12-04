
import java.sql.DriverManager;
import java.sql.*;
/**
 *
 * @author river
 */
public class VideoGame {

    
    public static void main(String[] args) {
        final String QUERY = "select id, name, system, year, genre from games";
        
        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/videogames", "river", "mucis");
                PreparedStatement stmt = con.prepareStatement(QUERY)){
            System.out.println(stmt.toString());
            
            ResultSet rs = stmt.executeQuery(QUERY);
            
            while(rs.next()){
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + 
                        rs.getString("system") + ", " + rs.getInt("year") + ", " + rs.getString("genre"));
            }
        } catch (SQLException ex) {
            System.out.println("retrieve SQLException: " + ex.getMessage());
        }
    }
    
}