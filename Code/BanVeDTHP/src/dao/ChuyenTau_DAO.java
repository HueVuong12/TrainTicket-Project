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
import entity.ChuyenTau;

public class ChuyenTau_DAO {
	ArrayList<ChuyenTau> dsChuyenTau;
    
    public ChuyenTau_DAO(){ 
        dsChuyenTau = new ArrayList<ChuyenTau>();  
    }
    
    public ArrayList<ChuyenTau> docTuBang()  { 
        try { 
            Connection con = ConnectDB.getInstance().getConnection(); 
            String sql = "Select * from ChuyenTau"; 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql); 
            while (rs.next()) { 
                String maTau = rs.getString("maTau");
                String gaDen = rs.getString("gaDen");
                LocalDate ngayDi = rs.getDate("ngayDi").toLocalDate();
                Timestamp gioDiStamp = rs.getTimestamp("gioDi");
	    		LocalTime gioDi =gioDiStamp.toLocalDateTime().toLocalTime();
                ChuyenTau chuyenTau = new ChuyenTau(maTau, gaDen, ngayDi,gioDi);
                dsChuyenTau.add(chuyenTau);
           } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return dsChuyenTau; 
    }
    
    public ArrayList<ChuyenTau> getChuyenTauBymaTau(String maTau) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        try {       
            String sql = "Select * from ChuyenTau where maTau = ?"; 
            stmt = con.prepareStatement(sql); 
            stmt.setString(1, maTau); 
            ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
                String gaDen = rs.getString("gaDen");
                LocalDate ngayDi = rs.getDate("ngayDi").toLocalDate();
                Timestamp gioDiStamp = rs.getTimestamp("gioDi");
	    		LocalTime gioDi =gioDiStamp.toLocalDateTime().toLocalTime();
                ChuyenTau chuyenTau = new ChuyenTau(maTau, gaDen, ngayDi,gioDi);
                dsChuyenTau.add(chuyenTau);
            } 
        } catch (SQLException e) { 
            e.printStackTrace();     
        } 
        
        return dsChuyenTau; 
    } 
    
    public boolean create(ChuyenTau chuyenTau) { 
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("insert into ChuyenTau values(?, ?, ?, ?)"); 
            stmt.setString(1, chuyenTau.getMaTau());
            stmt.setString(2, chuyenTau.getGaDen());
            stmt.setObject(3, chuyenTau.getNgayDi());
            stmt.setObject(4, chuyenTau.getGioDi());      
            n = stmt.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        
        return n > 0;
    } 
    
    public boolean update(ChuyenTau chuyenTau) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("update ChuyenTau set gaDen = ?, ngayDi = ?, gioDi = ? where maTau = ?"); 
            stmt.setString(4, chuyenTau.getMaTau());
            stmt.setString(1, chuyenTau.getGaDen());
            stmt.setObject(2, chuyenTau.getNgayDi());
            stmt.setObject(3, chuyenTau.getGioDi()); 
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    } 
           
    public boolean delete(String maTau) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("delete from ChuyenTau where maTau = ?"); 
            stmt.setString(1, maTau); 
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    }

    public void reset() {
        dsChuyenTau.removeAll(dsChuyenTau);
    }
}
