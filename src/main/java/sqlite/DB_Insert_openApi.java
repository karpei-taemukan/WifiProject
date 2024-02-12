package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class DB_Insert_openApi {

	public void insert(List<Map<String,String>> list) throws SQLException {

		
		DBConnection.connect();
		
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
    	connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/pc/Desktop/zb/eclipse/wifi-project/wifi-project/db/mydb.db");
    	 String sql = " INSERT INTO `wifi_info` "+ 
		            "("+"Distance, "
				    + "X_SWIFI_MGR_NO, "
		            + "X_SWIFI_WRDOFC, "
		            + "X_SWIFI_MAIN_NM,"
		            + "X_SWIFI_ADRES1, "
		            + "X_SWIFI_ADRES2, "
		            + "X_SWIFI_INSTL_FLOOR, "
		            + "X_SWIFI_INSTL_TY, "
		            + "X_SWIFI_INSTL_MBY, "
		            + "X_SWIFI_SVC_SE, "
		            + "X_SWIFI_CMCWR, "
		            + "X_SWIFI_CNSTC_YEAR, "
		            + "X_SWIFI_INOUT_DOOR, "
		            + "X_SWIFI_REMARS3, "
		            + "LAT, "
		            + "LNT, "
		            + "WORK_DTTM"+")"
		            +" values(100,?, ?, ?, ?, ?, IFNULL('',?), ?, ?, ?, ?, ?, ?, IFNULL('',?), ?, ?,?);";
  
        try {
        	connection.setAutoCommit(false);
				 
				  		
				    preparedStatement = connection.prepareStatement(sql);
					
				    for(int i=0; i<list.size(); i++) {
				 
				    preparedStatement.setString(1, list.get(i).get("X_SWIFI_MGR_NO"));
		            preparedStatement.setString(2, list.get(i).get("X_SWIFI_WRDOFC"));
		            preparedStatement.setString(3, list.get(i).get("X_SWIFI_MAIN_NM"));
		    	    preparedStatement.setString(4, list.get(i).get("X_SWIFI_ADRES1"));
		            preparedStatement.setString(5, list.get(i).get("X_SWIFI_ADRES2"));
		            preparedStatement.setString(6, list.get(i).get("X_SWIFI_INSTL_FLOOR"));
		    	    preparedStatement.setString(7, list.get(i).get("X_SWIFI_INSTL_TY"));
		            preparedStatement.setString(8, list.get(i).get("X_SWIFI_INSTL_MBY"));
		            preparedStatement.setString(9, list.get(i).get("X_SWIFI_SVC_SE"));
		    	    preparedStatement.setString(10, list.get(i).get("X_SWIFI_CMCWR"));
		            preparedStatement.setString(11, list.get(i).get("X_SWIFI_CNSTC_YEAR"));
		            preparedStatement.setString(12, list.get(i).get("X_SWIFI_INOUT_DOOR"));
		    	    preparedStatement.setString(13, list.get(i).get("X_SWIFI_REMARS3"));
		            preparedStatement.setDouble(14, Double.parseDouble(list.get(i).get("LAT")));
		            preparedStatement.setDouble(15, Double.parseDouble(list.get(i).get("LNT")));
		            preparedStatement.setString(16, list.get(i).get("WORK_DTTM"));
		            preparedStatement.addBatch();		
				    }
		  
				    preparedStatement.executeBatch();
				    preparedStatement.clearBatch();
				    connection.commit();
			  int affected = preparedStatement.executeUpdate();
			    
	            if(affected > 0){
	                System.out.println("INSERT SUCCESS");
	            }else{
	                System.out.println("INSERT FAIL");
	            }
	    
         
    } catch (SQLException | NumberFormatException e) {
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
	
	public void insert_history(double lat, double lnt) {
	DBConnection.connect();
		
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        
        try {
        	connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/pc/Desktop/zb/eclipse/wifi-project/wifi-project/db/mydb.db");
        	  String sql = "INSERT INTO `wifi_history` "+ 
			            "("+"X_SWIFI_ID, "
			            + "LAT, "
			            + "LNT, "
			            + "WORK_DTTM "+") "
			            + "values((SELECT ifnull(MAX(X_SWIFI_ID), 0) + 1 FROM wifi_history), ?, ?, datetime('now','localtime'));";
        	
        	  preparedStatement = connection.prepareStatement(sql);
        	  
              preparedStatement.setDouble(1, lat);
	          preparedStatement.setDouble(2, lnt);
        	  
    		  int affected = preparedStatement.executeUpdate();
			    
	            if(affected > 0){
	                System.out.println("INSERT HISTORY SUCCESS");
	            }else{
	                System.out.println("INSERT HISTORY FAIL");
	            }
	    
        }catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
        }finally{
        	DBConnection.close(rs, preparedStatement, connection);
        }
	}
}
