package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Wifi.Wifi_Info;

public class DB_Update_openApi {

	public void update(List<Wifi_Info> list) throws SQLException {
		DBConnection.connect();
	
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
    	connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/pc/Desktop/zb/eclipse/wifi-project/wifi-project/db/mydb.db");

      	
    	
        try {
        	connection.setAutoCommit(false);
        	String sql =  " UPDATE wifi_info"
   				 +" SET"
   				 +" distance = ?"
   				 +" where X_SWIFI_MGR_NO = ? ;";
        	
        	preparedStatement = connection.prepareStatement(sql);
        	
        	for(int i=0; i<list.size(); i++) {
        	preparedStatement.setDouble(1, list.get(i).getDistance());
        	preparedStatement.setString(2, list.get(i).getX_SWIFI_MGR_NO());
        	preparedStatement.addBatch();
        	}
        	preparedStatement.executeBatch();
		    preparedStatement.clearBatch();
		   	connection.commit();
        
      
        	
        }catch(SQLException e) {
        	  e.printStackTrace();
        	  try {
              	connection.rollback();
      		} catch(SQLException e1) {
      			e1.printStackTrace();
      		}
        }finally{
        	DBConnection.close(rs, preparedStatement, connection);
        }
           
        
        
	}
}
