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
public class data_transaksi {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_transaksi;
    public String id_pc;
    public String id_penyewa;
    public String merek_pc;
    public String harga;
    public String sewa_jam;
    public String biaya;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO tbl_transaksi(id_transaksi,id_pc,id_penyewa,merek_pc,harga,sewa_jam,biaya)VALUE(?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_transaksi);
        pst.setString(2,id_pc);
        pst.setString(3,id_penyewa);
        pst.setString(4,merek_pc);
        pst.setString(5,harga);
        pst.setString(6,sewa_jam);
        pst.setString(7,biaya);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE tbl_transaksi set id_pc=?, id_penyewa=?, merek_pc=?, harga=?, sewa_jam=?, biaya=? where id_transaksi=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_pc);
        pst.setString(2,id_penyewa);
        pst.setString(3,merek_pc);
        pst.setString(4,harga);
        pst.setString(5,sewa_jam);
        pst.setString(6,biaya);
        pst.setString(7,id_transaksi);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from tbl_transaksi where id_transaksi=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_transaksi);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet Updatetbl_transaksi()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_transaksi,id_pc,id_penyewa,merek_pc,harga,sewa_jam,biaya from tbl_transaksi";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }

}