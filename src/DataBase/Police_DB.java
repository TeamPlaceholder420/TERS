package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Police_DB implements DB {
	
	OracleJDBCConnection con;

	@Override
	public void register(double x, double y) {
		// TODO Auto-generated method stub
		
		Connection conn = OracleJDBCConnection.connectDataBase();
		Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(OracleJDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql = "SELECT * FROM POLICE WHERE X = 1 AND Y = 1"; //STUB BETTER FIX SOON
        
        
	}

	@Override
	public void unregister(int id, double new_x, double new_y) {
		// TODO Auto-generated method stub
		
	}
	
	

}
