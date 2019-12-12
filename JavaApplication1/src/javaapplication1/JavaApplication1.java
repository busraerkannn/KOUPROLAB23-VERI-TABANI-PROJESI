package javaapplication1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class VeriBaglanti {
	
	static Connection myConn;
	static Statement myStat;
	
	static ResultSet baglan(String tabloAdi){
		ResultSet myRs=null;
		try {
			
			myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","1813");
			myStat = (Statement) myConn.createStatement();
			myRs = myStat.executeQuery("select * from " + tabloAdi);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myRs;
	}
	
	static void ekle(String sql_sorgu) {
		
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ResultSet ara(String hammadde){
		ResultSet myRs2=null;
		try {
			
			myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","1813");
			myStat = (Statement) myConn.createStatement();
			myRs2 = myStat.executeQuery("select * from tedarikci where hammadde='Hidrojen'");

			//myRs2 = myStat.executeQuery("select * from tedarikci where hammadde= '" + hammadde + "';");
			//System.out.println(myRs2.getString("firmaID"));
			
			if(!myRs2.next())
			{
				System.out.println("dknflf");
			}
				
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myRs2;
	}

}
