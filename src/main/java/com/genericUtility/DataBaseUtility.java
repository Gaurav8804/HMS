package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {

	Connection conn=null;
	public void toConnectToDataBase() throws SQLException 
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
	    conn = DriverManager.getConnection(IPathConstants.DBURL,IPathConstants.DBUSERNAME,IPathConstants.DBPASSWORD);
                  
	}
	
	public String executeandgetdata(String Query,int collINDEX,String expected) throws SQLException 
	{
		 Statement stat = conn.createStatement();
         ResultSet res = stat.executeQuery(Query);
         boolean flag=false;
         while(res.next()) 
         {
        	String actual = res.getString(collINDEX);
        	 if(actual.equalsIgnoreCase(expected))
        	 {
        		 flag=true;
        		 break;
        	}
         }
        	 if(flag==true) 
             {
            	 System.out.println("Data is verified");
            	 return expected; 
             }else 
             {
            	 System.out.println("Data mismatched");
            	 return "";
             }
        	 
        	
        }
	
	
         
     public void closeDBConnection() throws SQLException 
     {
    	conn.close(); 
     }    
     
	}       
         
         
         
	
	
	
	
	

