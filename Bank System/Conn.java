// *****************CODE BY RUCHIR JAIN******************
import java.sql.*;

public class Conn {
    /* TOTAL 5 STEPS
        1. REGISTER THE DRIVER
        2. CREATE CONNECTION
        3. CREATE STATEMENT
        4. EXECUTE QUERY
        5. CLOSE CONNECTION
         */
    Connection c;
    Statement s;

    public Conn() {

        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost/banksystem", "root", "@Ruchir2003");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
