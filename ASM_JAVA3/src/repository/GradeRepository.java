/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import Repository.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GRADES;

/**
 *
 * @author admin
 */
public class GradeRepository {

    ArrayList<GRADES> listGR;
    ResultSet rs = null;
    Statement st = null;
    DBConnection dbcn;

    public GradeRepository() {
    }

    public ArrayList<GRADES> getGradeDB() {
        String select = "select * from GRADES";
        listGR  = new ArrayList<>();
        try {
            st = dbcn.openDBConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listGR.add(new GRADES(rs.getInt(1), rs.getNString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listGR;
    }

    public String addGradeDB(String MaSV) {
        String addDB = "insert into grades (MaSV, TiengAnh, TinHoc, GDTC) values (N'" + MaSV + "',0,0,0);";
        try {
            st = dbcn.openDBConnection().createStatement();
            st.executeUpdate(addDB);
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Thêm thành công";
    }

    public String deleteGradeDB(String MaSV) {
        String deleteDB = "delete from grades where masv = '" + MaSV + "'";
        try {
            st = dbcn.openDBConnection().createStatement();
            st.executeUpdate(deleteDB);
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Xóa thành công";
    }

    public String updateGradeDB(GRADES gr) {
        String updateDB = "update Grades set  TiengAnh ='" + gr.getTiengAnh() + "', TinHoc = '" + gr.getTinHoc() + "', GDTC = '" + gr.getGdTC() + "' where masv = '" + gr.getMaSV() + "'";
        try {
            st = dbcn.openDBConnection().createStatement();
            st.executeUpdate(updateDB);
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Cập nhật thành công";
    }

    public GRADES searchGradeDB(String MaSV) {
        String searchDB = "Select * from GRADES where masv = '" + MaSV + "'";
        GRADES gr = null;
        try {
            st = dbcn.openDBConnection().createStatement();
            rs = st.executeQuery(searchDB);
            while (rs.next()) {
                gr = new GRADES(rs.getNString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gr;
    }
    
    public ArrayList<GRADES> sortGradeDB(){
        listGR  = new ArrayList<>();
        String sortDB = "select top 3 MASV, TIENGANH, TINHOC, GDTC from grades order by ((TiengAnh + TinHoc + GDTC) / 3) desc";
        try {
            st = dbcn.openDBConnection().createStatement();
            rs = st.executeQuery(sortDB);
            while (rs.next()){
                listGR.add(new GRADES(rs.getNString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GradeRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listGR;
    }
}
