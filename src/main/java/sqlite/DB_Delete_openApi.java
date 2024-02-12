package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Delete_openApi {

	public void delete(int idx) {
		DBConnection.connect();
		
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        try {
        	connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/pc/Desktop/zb/eclipse/wifi-project/wifi-project/db/mydb.db");
        		

        	String sql =  " delete from wifi_history"
        				 +" where X_SWIFI_ID = ? ;";
        	preparedStatement = connection.prepareStatement(sql);

        	preparedStatement.setInt(1, idx);

      	  int affected = preparedStatement.executeUpdate();
      	    
            if(affected > 0){
                System.out.println("UPDATE SUCCESS");
            }else{
                System.out.println("UPDATE FAIL");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
        	DBConnection.close(rs, preparedStatement, connection);

        }
	}
}
