package repository;

import Repository.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.STUDENTS;

public class StudentsRepository {

    ArrayList<STUDENTS> listST = new ArrayList<>();
    ResultSet rs = null;
    Statement st = null;
    DBConnection dbcn;

    public StudentsRepository() {
    }

    public ArrayList<STUDENTS> getStudentsDB() {
        try {
            String select = "select * from STUDENTS";
            st = dbcn.openDBConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()) {
                listST.add(new STUDENTS(rs.getNString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getBoolean(5), rs.getNString(6), rs.getNString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listST;
    }

    public String addStudentDB(STUDENTS stu) {
        int gioiTinh = 0;
        if (stu.isGioiTinh() == true) {
            gioiTinh = 1;
        } else {
            gioiTinh = 0;
        }
        String addST = "insert into students values (N'" + stu.getMaSV() + "',N'" + stu.getHoTen() + "',N'" + stu.getEmail() + "',N'" + stu.getSdt() + "'," + gioiTinh + ",N'" + stu.getDiaChi() + "',N'" + stu.getHinh() + "')";
        try {
            st = dbcn.openDBConnection().createStatement();
            st.executeUpdate(addST);
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Thêm thất bại";
        }
    }

    public String removeStudentDB(STUDENTS stu) {
        String deleteST = "delete from students where MASV = '" + stu.getMaSV() + "'";
        try {
            st = dbcn.openDBConnection().createStatement();
            st.executeUpdate(deleteST);
            return "Xóa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xóa thất bại";
        }
        
    }

    
    public String updateStudentDB(STUDENTS stu){
        int gioiTinh = 0;
        if (stu.isGioiTinh() == true) {
            gioiTinh = 1;
        } else {
            gioiTinh = 0;
        }
        String updateST = "update students set MASV = N'"+stu.getMaSV()+"', HoTen = N'"+stu.getHoTen()+"', Email = N'"+stu.getEmail()+"', SDT = N'"+stu.getSdt()+"', GioiTinh = "+gioiTinh+", DiaChi = N'"+stu.getDiaChi()+"', Hinh = N'"+stu.getHinh()+"' where MASV = '"+stu.getMaSV()+"'";
          try {
            st = dbcn.openDBConnection().createStatement();
            st.executeUpdate(updateST);
            return "Cập nhật thành công";
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Cập nhật thất bại";
        }
    }
    
    public String getNameStDB(String maSV){
        String selectName = "select hoTen from students where MASV = '"+maSV+"'";
        String hoTen = null;
        try {
            st = dbcn.openDBConnection().createStatement();
            rs = st.executeQuery(selectName);
            while (rs.next()){
                hoTen = rs.getNString(1);
            }
            return hoTen;
        } catch (SQLException ex) {
            Logger.getLogger(StudentsRepository.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }
    
    public static void main(String[] args) {
        for (STUDENTS o : new StudentsRepository().getStudentsDB()) {
            System.out.println(o.toString());
        }
    }
}
