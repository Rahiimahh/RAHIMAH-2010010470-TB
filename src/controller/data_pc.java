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
public class data_pc {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String id_pc;
    public String merek_pc;
    public String ram;
    public String penyimpanan;
    public String harga;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO tbl_datapc(id_pc,merek_pc,ram,penyimpanan,harga)VALUE(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_pc);
        pst.setString(2,merek_pc);
        pst.setString(3,ram);
        pst.setString(4,penyimpanan);
        pst.setString(5,harga);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE tbl_datapc set merek_pc=?, ram=?, penyimpanan=?, harga=? where id_pc=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,merek_pc);
        pst.setString(2,ram);
        pst.setString(3,penyimpanan);
        pst.setString(4,harga);
        pst.setString(5,id_pc);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from tbl_datapc where id_pc=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, id_pc);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet Updatetbl_datapc()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select id_pc,merek_pc,ram,penyimpanan,harga from tbl_datapc";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
    
}