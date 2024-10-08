package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;
import entity.NhanVien;

public class TaiKhoan_DAO {

    ArrayList<TaiKhoan> dsTaiKhoan;
	private NhanVien_DAO nv = new NhanVien_DAO();

    public TaiKhoan_DAO() {
        dsTaiKhoan = new ArrayList<TaiKhoan>();
    }

    public ArrayList<TaiKhoan> docTuBang() {
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM TaiKhoan";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maTaiKhoan = rs.getString("maTaiKhoan");
                String matKhau = rs.getString("matKhau");
                int phanQuyen = rs.getInt("phanQuyen");
                String maNV = rs.getString("nhanVien");

                // Sử dụng getNhanVienByMaNV của NhanVien để lấy thẳng dữ liệu từ CSDL
                NhanVien nhanVien = nv.getNhanVienTheoMaNV(maNV);

                TaiKhoan taiKhoan = new TaiKhoan(maTaiKhoan, matKhau, phanQuyen, nhanVien);
                dsTaiKhoan.add(taiKhoan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsTaiKhoan;
    }

    public boolean create(TaiKhoan tk) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("INSERT INTO TaiKhoan VALUES(?, ?, ?, ?)");
            stmt.setString(1, tk.getMaTaiKhoan());
            stmt.setString(2, tk.getMatKhau());
            stmt.setInt(3, tk.getPhanQuyen());
            stmt.setString(4, tk.getNhanVien().getMaNV()); // Lấy mã nhân viên từ đối tượng NhanVien

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    public boolean update(TaiKhoan tk) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("UPDATE TaiKhoan SET matKhau = ?, phanQuyen = ?, nhanVien = ? WHERE maTaiKhoan = ?");
            stmt.setString(1, tk.getMatKhau());
            stmt.setInt(2, tk.getPhanQuyen());
            stmt.setString(3, tk.getNhanVien().getMaNV()); // Lấy mã nhân viên từ đối tượng NhanVien
            stmt.setString(4, tk.getMaTaiKhoan());

            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    public boolean delete(String maTaiKhoan) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        int n = 0;
        try {
            stmt = con.prepareStatement("DELETE FROM TaiKhoan WHERE maTaiKhoan = ?");
            stmt.setString(1, maTaiKhoan);
            n = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n > 0;
    }

    public TaiKhoan getTaiKhoanTheoMaTK(String maTaiKhoan) {
        TaiKhoan taiKhoan = null;

        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;

        try {
            String sql = "SELECT * FROM TaiKhoan WHERE maTaiKhoan = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maTaiKhoan);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String matKhau = rs.getString("matKhau");
                int phanQuyen = rs.getInt("phanQuyen");
                String maNV = rs.getString("nhanVien");

             // Sử dụng getNhanVienByMaNV của NhanVien để lấy thẳng dữ liệu từ CSDL
                NhanVien nhanVien = nv.getNhanVienTheoMaNV(maNV);

                taiKhoan = new TaiKhoan(maTaiKhoan, matKhau, phanQuyen, nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taiKhoan;
    }

    public void reset() {
        dsTaiKhoan.removeAll(dsTaiKhoan);
    }
}
