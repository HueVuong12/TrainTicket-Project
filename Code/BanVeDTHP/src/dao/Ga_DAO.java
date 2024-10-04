package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Ga;


public class Ga_DAO {
	ArrayList<Ga> dsGa;
    
    public Ga_DAO(){ 
        dsGa = new ArrayList<Ga>();  
    }
    
    public ArrayList<Ga> docTuBang()  { 
        try { 
            Connection con = ConnectDB.getInstance().getConnection(); 
            String sql = "Select * from Ga"; 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql); 
            while (rs.next()) { 
                String maGa = rs.getString("maGa");
                String tenGa = rs.getString("tenGa");
                String diaChi = rs.getString("diaChi");
                boolean trangThai = rs.getBoolean("trangThai");
                int chiSoKm= rs.getInt("chiSoKm");
                Ga Ga = new Ga(maGa, tenGa, diaChi, chiSoKm,trangThai);
                dsGa.add(Ga);
           } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return dsGa; 
    }
    
    public ArrayList<Ga> getGaBymaGa(String maGa) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        try {       
            String sql = "Select * from Ga where maGa = ?"; 
            stmt = con.prepareStatement(sql); 
            stmt.setString(1, maGa); 
            ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
                String tenGa = rs.getString("tenGa");
                String diaChi = rs.getString("diaChi");
                boolean trangThai = rs.getBoolean("trangThai");
                int chiSoKm= rs.getInt("chiSoKm");
                Ga Ga = new Ga(maGa, tenGa, diaChi, chiSoKm,trangThai);
                dsGa.add(Ga);
            } 
        } catch (SQLException e) { 
            e.printStackTrace();     
        } 
        
        return dsGa; 
    } 
    
    public boolean create(Ga ga) { 
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("insert into Ga values(?, ?, ?, ?, ?)"); 
            stmt.setString(1, ga.getMaGa());
            stmt.setString(2, ga.getTenGa());
            stmt.setString(3, ga.getDiaChi());
            stmt.setInt(4, ga.getChiSoKm());
            stmt.setBoolean(5, ga.isTrangThai());
            
            
            n = stmt.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        
        return n > 0;
    } 
    
    public boolean update(Ga ga) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("update Ga set tenGa = ?, diaChi = ?, chiSoKm = ?, trangThai = ? where maGa = ?"); 
            stmt.setString(1, ga.getTenGa());
            stmt.setString(2, ga.getDiaChi());
            stmt.setInt(3, ga.getChiSoKm());
            stmt.setBoolean(4, ga.isTrangThai());
            stmt.setString(5, ga.getMaGa());
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    } 
           
    public boolean delete(String maGa) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("delete from Ga where maGa = ?"); 
            stmt.setString(1, maGa); 
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    }

    public void reset() {
        dsGa.removeAll(dsGa);
    }
}
