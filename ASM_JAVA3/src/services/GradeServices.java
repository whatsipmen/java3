/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import model.GRADES;
import repository.GradeRepository;

/**
 *
 * @author admin
 */
public class GradeServices {
    GradeRepository grs = new GradeRepository();
    
    public ArrayList<GRADES> getListGrade(){
        return grs.getGradeDB();
    }
    
    public String addGrade(String MaSV){
        return grs.addGradeDB(MaSV);
    }
    
    public String deleteGrade(String MaSV){
        return grs.deleteGradeDB(MaSV);
    }
    
    public String updateGrade(GRADES gr){
        return grs.updateGradeDB(gr);
    }
    
    public GRADES searchGrade(String MaSV){
        return grs.searchGradeDB(MaSV);
    }
    
    public ArrayList<GRADES> sortGrade(){
        return grs.sortGradeDB();
    }
}
