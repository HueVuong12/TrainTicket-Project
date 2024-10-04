package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Ca;

public class Ca_DAO {
		ArrayList<Ca> dsCa;
		public Ca_DAO(){ 
			dsCa = new ArrayList<Ca>();  
		}
		public ArrayList<Ca> docTuBang()  { 
		    try { 
		    	Connection con = ConnectDB.getInstance().getConnection(); 
		    	String sql = "Select * from Ca"; 
		    	Statement statement = con.createStatement(); 
		    	ResultSet rs = statement.executeQuery(sql); 
		    	while (rs.next()) {
		    		String maCA = rs.getString(1); 
		    		String tenCA = rs.getString(2);  
		    		Timestamp thoiGianBatDaustamp = rs.getTimestamp(3);
		    		LocalTime thoiGianBatDau =thoiGianBatDaustamp.toLocalDateTime().toLocalTime();
		    		Timestamp thoiGianKetThucstamp = rs.getTimestamp(4);
		    		LocalTime thoiGianKetThuc =thoiGianKetThucstamp.toLocalDateTime().toLocalTime(); 
		    		Ca ca = new Ca(maCA, tenCA, thoiGianBatDau,thoiGianKetThuc);
		    		dsCa.add(ca);
		       } 
		    } catch (SQLException e) { 
		    	e.printStackTrace(); 
		    } 
		    return dsCa; 
		}
		public ArrayList<Ca> getKHTheoMaCa(String maCa) { 
			Connection con = ConnectDB.getInstance().getConnection(); 
			PreparedStatement stmt =null; 
			try {       
				String sql = "Select * from Ca where maCa = ?"; 
				//String sql = "Select * from KhachHang"; 
				stmt = con.prepareStatement(sql); 
				stmt.setString(1, maCa); 
				ResultSet rs = stmt.executeQuery(); 
				while (rs.next()) {
					String maCa = rs.getString(1); 
		    		String tenCa = rs.getString(2);  
		    		Timestamp thoiGianBatDaustamp = rs.getTimestamp(3);
		    		LocalTime thoiGianBatDau =thoiGianBatDaustamp.toLocalDateTime().toLocalTime();
		    		Timestamp thoiGianKetThucstamp = rs.getTimestamp(4);
		    		LocalTime thoiGianKetThuc =thoiGianKetThucstamp.toLocalDateTime().toLocalTime(); 
		    		Ca ca = new Ca(maCa, tenCa, thoiGianBatDau,thoiGianKetThuc);
		           
		    		dsCa.add(ca);
				} 
			} catch (SQLException e) { 
				e.printStackTrace();     
			} 
			
			return dsCa; 
		} 
		
		public boolean create(Ca ca) { 
			Connection con = ConnectDB.getInstance().getConnection();
			PreparedStatement stmt = null; 
			int n = 0; 
			try { 
				stmt = con.prepareStatement("insert into KhachHang values(?, ?, ?, ?)"); 
				stmt.setString(1,ca.getMaCa());
				stmt.setString(2,ca.getTenCa());
				stmt.setObject(3,ca.getThoiGianBatDau());
				stmt.setObject(4,ca.getThoiGianKetThuc());
				n = stmt.executeUpdate();
			} catch (SQLException e) { 
				e.printStackTrace(); 
			}
			return n > 0;
		} 
		//U: Update 
		public boolean update(Ca ca) { 
			Connection con = ConnectDB.getInstance().getConnection(); 
			PreparedStatement stmt = null; 
			int n = 0; 
			try { 
				stmt = con.prepareStatement("update Ca set maCa = ?, tenCa = ?, thoiGianBatDau = ?, thoiGianKetThuc = ? where maCa = ?"); 
				stmt.setString(1,ca.getMaCa());
				stmt.setString(2,ca.getTenCa());
				stmt.setObject(3,ca.getThoiGianBatDau());
				stmt.setObject(4,ca.getThoiGianKetThuc());
			     
			    n = stmt.executeUpdate(); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
			} 
			
			return n > 0;
		} 
			   
		public void reset() {
			dsCa.removeAll(dsCa);
		}
		
//		public Ca getCacapByma(String maCa){
//			Ca ca = null;
//			Connection con = null;
//			PreparedStatement stmt = null;
//
//			try {
//				con = ConnectDB.getConnection();
//				String sql = "SELECT * FROM Ca WHERE [maCa] = ?";
//				stmt = con.prepareStatement(sql);
//				stmt.setString(1, maCa);
//				ResultSet rs = stmt.executeQuery();
//
//				if (rs.next()) {
//					String maCA = rs.getString(1); 
//		    		String tenCA = rs.getString(2);  
//		    		Timestamp thoiGianBatDaustamp = rs.getTimestamp(3);
//		    		LocalTime thoiGianBatDau =thoiGianBatDaustamp.toLocalDateTime().toLocalTime();
//		    		Timestamp thoiGianKetThucstamp = rs.getTimestamp(4);
//		    		LocalTime thoiGianKetThuc =thoiGianKetThucstamp.toLocalDateTime().toLocalTime(); 
//		    		ca = new Ca(maCA, tenCA, thoiGianBatDau,thoiGianKetThuc);
//							
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//			return ca;
//		}
}
