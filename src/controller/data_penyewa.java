/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class data_penyewa {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_penyewa;
    public String nama;
    public String alamat;
    public String no_hp;
    public String email;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO tbl_penyewa(id_penyewa,nama,alamat,no_hp,email)VALUE(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_penyewa);
        pst.setString(2,nama);
        pst.setString(3,alamat);
        pst.setString(4,no_hp);
        pst.setString(5,email);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE tbl_penyewa set nama=?, alamat=?, no_hp=?, email=? where id_penyewa=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama);
        pst.setString(2,alamat);
        pst.setString(3,no_hp);
        pst.setString(4,email);
        pst.setString(5,id_penyewa);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from tbl_penyewa where id_penyewa=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_penyewa);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet Updatetbl_penyewa()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_penyewa,nama,alamat,no_hp,email from tbl_penyewa";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }

}