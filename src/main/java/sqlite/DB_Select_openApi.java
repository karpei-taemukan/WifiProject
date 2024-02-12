package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Wifi.Wifi_History;
import Wifi.Wifi_Info;



public class DB_Select_openApi {


	
	
	public List<Wifi_Info> select() throws SQLException {
		
		List<Wifi_Info> wifiList = new ArrayList<>();
		
		
		DBConnection.connect();
		
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
    	connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/pc/Desktop/zb/eclipse/wifi-project/wifi-project/db/mydb.db");
        
        try {
        	
        	String sql =  "	SELECT *"
        				+ " from wifi_info wi ;";
        	
        	preparedStatement = connection.prepareStatement(sql);
        	 rs = preparedStatement.executeQuery();

        	 
        	 while (rs.next()) {
        	   double Distance = rs.getDouble("Distance");
               String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
               String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
               String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
               String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
               String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
               String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
               String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
               String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
               String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
               String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
               String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
               String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
               String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
               double LAT = Double.parseDouble(rs.getString("LAT"));
               double LNT = Double.parseDouble(rs.getString("LNT"));
               String WORK_DTTM = rs.getString("WORK_DTTM");
               
               
               Wifi_Info wi = new Wifi_Info();
              wi.setDistance(Distance);
              wi.setX_SWIFI_MGR_NO(X_SWIFI_MGR_NO);
         	  wi.setX_SWIFI_WRDOFC(X_SWIFI_WRDOFC);					  
         	  wi.setX_SWIFI_MAIN_NM(X_SWIFI_MAIN_NM);
         	  wi.setX_SWIFI_ADRES1(X_SWIFI_ADRES1);
         	  wi.setX_SWIFI_ADRES2(X_SWIFI_ADRES2);
         	  wi.setX_SWIFI_INSTL_FLOOR(X_SWIFI_INSTL_FLOOR);
         	  wi.setX_SWIFI_INSTL_TY(X_SWIFI_INSTL_TY);
         	  wi.setX_SWIFI_INSTL_MBY(X_SWIFI_INSTL_MBY);
         	  wi.setX_SWIFI_SVC_SE(X_SWIFI_SVC_SE);
         	  wi.setX_SWIFI_CMCWR(X_SWIFI_CMCWR);
         	  wi.setX_SWIFI_CNSTC_YEAR(X_SWIFI_CNSTC_YEAR);
         	  wi.setX_SWIFI_INOUT_DOOR(X_SWIFI_INOUT_DOOR);
         	  wi.setX_SWIFI_REMARS3(X_SWIFI_REMARS3);
         	  wi.setLAT(LAT); 
         	  wi.setLNT(LNT);
         	  wi.setWORK_DTTM(WORK_DTTM);
         	  
         	 wifiList.add(wi);
        	 }
        }catch(SQLException e){
        	e.printStackTrace();
        }finally{
        	DBConnection.close(rs, preparedStatement, connection);
        }
           
        
        return wifiList;
	}
	
	
public List<Wifi_Info> select_near() throws SQLException {
		
		List<Wifi_Info> wifiList = new ArrayList<>();
		
		
		DBConnection.connect();
		
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

    	connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/pc/Desktop/zb/eclipse/wifi-project/wifi-project/db/mydb.db");

        
        try {
        	
        	String sql =  "	SELECT *"
        				+ " FROM wifi_info wi "
        				+ "	WHERE distance <= 1"
        				+ "	LIMIT 20;";
        	
        	preparedStatement = connection.prepareStatement(sql);
        	 rs = preparedStatement.executeQuery();

        	 
        	 while (rs.next()) {
        	   double Distance = rs.getDouble("Distance");
               String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
               String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
               String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
               String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
               String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
               String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
               String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
               String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
               String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
               String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
               String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
               String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
               String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
               double LAT = Double.parseDouble(rs.getString("LAT"));
               double LNT = Double.parseDouble(rs.getString("LNT"));
               String WORK_DTTM = rs.getString("WORK_DTTM");
               
               
               Wifi_Info wi = new Wifi_Info();
              wi.setDistance(Distance);
              wi.setX_SWIFI_MGR_NO(X_SWIFI_MGR_NO);
         	  wi.setX_SWIFI_WRDOFC(X_SWIFI_WRDOFC);					  
         	  wi.setX_SWIFI_MAIN_NM(X_SWIFI_MAIN_NM);
         	  wi.setX_SWIFI_ADRES1(X_SWIFI_ADRES1);
         	  wi.setX_SWIFI_ADRES2(X_SWIFI_ADRES2);
         	  wi.setX_SWIFI_INSTL_FLOOR(X_SWIFI_INSTL_FLOOR);
         	  wi.setX_SWIFI_INSTL_TY(X_SWIFI_INSTL_TY);
         	  wi.setX_SWIFI_INSTL_MBY(X_SWIFI_INSTL_MBY);
         	  wi.setX_SWIFI_SVC_SE(X_SWIFI_SVC_SE);
         	  wi.setX_SWIFI_CMCWR(X_SWIFI_CMCWR);
         	  wi.setX_SWIFI_CNSTC_YEAR(X_SWIFI_CNSTC_YEAR);
         	  wi.setX_SWIFI_INOUT_DOOR(X_SWIFI_INOUT_DOOR);
         	  wi.setX_SWIFI_REMARS3(X_SWIFI_REMARS3);
         	  wi.setLAT(LAT); 
         	  wi.setLNT(LNT);
         	  wi.setWORK_DTTM(WORK_DTTM);
         	  
         	 wifiList.add(wi);
        	 }
        }catch(SQLException e){
        	e.printStackTrace();
        }finally{
        	DBConnection.close(rs, preparedStatement, connection);
        }
           
        
        return wifiList;
	}

	
	public List<Wifi_History> select_history() {
		List<Wifi_History> wifi_his_List = new ArrayList<>();
		
		
		DBConnection.connect();
		
	    Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        
        
       try {
    	   	connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/pc/Desktop/zb/eclipse/wifi-project/wifi-project/db/mydb.db");
        	
        	String sql =  "	SELECT *"
        				+ " from wifi_history ;";
        	
        	preparedStatement = connection.prepareStatement(sql);
        	 rs = preparedStatement.executeQuery();
        	 
        	 while (rs.next()) {
        		 int X_SWIFI_ID = rs.getInt("X_SWIFI_ID");
        		 double LAT = rs.getDouble("LAT");
        		 double LNT = rs.getDouble("LNT");
        		 String WORK_DTTM = rs.getString("WORK_DTTM");
        		 
        		 
        		 Wifi_History wh = new Wifi_History();
        		 wh.setX_SWIFI_ID(X_SWIFI_ID);
        		 wh.setLAT(LAT);
        		 wh.setLNT(LNT);
        		 wh.setWORK_DTTM(WORK_DTTM);
        		 
        		 wifi_his_List.add(wh);
        	 }
       }catch(SQLException e){
       	e.printStackTrace();
       }finally{
       	DBConnection.close(rs, preparedStatement, connection);
       }
	return wifi_his_List;
      
	}

}
