package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Ca;
import entity.NhanVien;

public class NhanVien_DAO {
    
    ArrayList<NhanVien> dsNhanVien;
    
    public NhanVien_DAO(){ 
        dsNhanVien = new ArrayList<NhanVien>();  
    }
    
    public ArrayList<NhanVien> docTuBang()  { 
        try { 
            Connection con = ConnectDB.getInstance().getConnection(); 
            String sql = "Select * from NhanVien"; 
            Statement statement = con.createStatement(); 
            ResultSet rs = statement.executeQuery(sql); 
            while (rs.next()) { 
                String maNV = rs.getString("maNV");
                String tenNV = rs.getString("tenNV");
                LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Ca ca = new Ca(rs.getString("ca"));
                String cccd = rs.getString("cccd");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                boolean trangThai = rs.getBoolean("trangThai");
                String chucVu = rs.getString("chucVu");

                NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, ca, cccd, email, sdt, trangThai, chucVu);
                
                dsNhanVien.add(nhanVien);
           } 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        return dsNhanVien; 
    }
    
    public ArrayList<NhanVien> getNhanVienByMaNV(String maNV) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        try {       
            String sql = "Select * from NhanVien where maNV = ?"; 
            stmt = con.prepareStatement(sql); 
            stmt.setString(1, maNV); 
            ResultSet rs = stmt.executeQuery(); 
            while (rs.next()) {
            	String tenNV = rs.getString("tenNV");
                LocalDate ngaySinh = rs.getDate("ngaySinh").toLocalDate();
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                Ca ca = new Ca(rs.getString("ca"));
                String cccd = rs.getString("cccd");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                boolean trangThai = rs.getBoolean("trangThai");
                String chucVu = rs.getString("chucVu");

                NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, ca, cccd, email, sdt, trangThai, chucVu);
                
                dsNhanVien.add(nhanVien);
            } 
        } catch (SQLException e) { 
            e.printStackTrace();     
        } 
        
        return dsNhanVien; 
    } 
    
    public boolean create(NhanVien nv) { 
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("insert into NhanVien values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getTenNV());
            stmt.setDate(3, java.sql.Date.valueOf(nv.getNgaySinh()));
            stmt.setBoolean(4, nv.isGioiTinh());
            stmt.setString(5, nv.getCa().getMaCa());
            stmt.setString(6, nv.getCccd());
            stmt.setString(7, nv.getEmail());
            stmt.setString(8, nv.getSdt());
            stmt.setBoolean(9, nv.isTrangThai());
            stmt.setString(10, nv.getChucVu());
            
            n = stmt.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        
        return n > 0;
    } 
    
    public boolean update(NhanVien nv) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("update NhanVien set tenNV = ?, ngaySinh = ?, gioiTinh = ?, ca = ?, cccd = ?, email = ?, sdt = ?, trangThai = ?, chucVu = ? where maNV = ?"); 
            stmt.setString(1, nv.getTenNV());
            stmt.setDate(2, java.sql.Date.valueOf(nv.getNgaySinh()));
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getCa().getMaCa());
            stmt.setString(5, nv.getCccd());
            stmt.setString(6, nv.getEmail());
            stmt.setString(7, nv.getSdt());
            stmt.setBoolean(8, nv.isTrangThai());
            stmt.setString(9, nv.getChucVu());
            stmt.setString(10, nv.getMaNV());
            
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    } 
           
    public boolean delete(String maNV) { 
        Connection con = ConnectDB.getInstance().getConnection(); 
        PreparedStatement stmt = null; 
        int n = 0; 
        try { 
            stmt = con.prepareStatement("delete from NhanVien where maNV = ?"); 
            stmt.setString(1, maNV); 
            n = stmt.executeUpdate(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
        
        return n > 0;
    }

    public void reset() {
        dsNhanVien.removeAll(dsNhanVien);
    }
}