package Servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Distance.Min_distance;
import Wifi.Wifi_Info;
import sqlite.DB_Insert_openApi;
import sqlite.DB_Select_openApi;
import sqlite.DB_Update_openApi;

@WebServlet("/Get_Position")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String myLat = req.getParameter("myLat");
		String myLnt = req.getParameter("myLnt"); 
		
		System.out.println("MYLAT : " + myLat);
		
		DB_Select_openApi dbsel = new DB_Select_openApi();
		DB_Insert_openApi dbinsert_his = new DB_Insert_openApi();
		DB_Update_openApi dbupdate = new DB_Update_openApi();
		Min_distance min = new  Min_distance();

		
		
		List<Wifi_Info> wifiList = null;
		try {
			wifiList = dbsel.select();
			System.out.println("SELECT SUCCESS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("/Get_Position_Update");
		 * 
		 * req.setAttribute("myLnt", myLnt); req.setAttribute("myLat", myLat);
		 * req.setAttribute("wifiList", wifiList);
		 * 
		 * rd.forward(req, res);
		 */
	
		
	
	  for(Wifi_Info wi : wifiList) { 
	  System.out.println("before update: "+wi.getDistance());
	  
		  double dis =
	  min.distanceInKilometerByHaversine(Double.parseDouble(myLat),
	  Double.parseDouble(myLnt), wi.getLAT(), wi.getLNT());
		  
	  wi.setDistance(Math.round(dis*100)/100.0); 
	  
	  System.out.println("after update: "+wi.getDistance());
	  System.out.println("UPDATING...");
	  }
	  
	  
	 
	  
	  try { 
		  System.out.println("UPDATING DB");
		  dbupdate.update(wifiList); 
		  System.out.println("UPDATING DONE");
	  } catch (SQLException e) {
	  e.printStackTrace(); 
	  }
//	 
		 
		
		
		  dbinsert_his.insert_history(Double.parseDouble(myLat), Double.parseDouble(myLnt));
		
		
	}
	 
	
}
