
package services;

import java.util.ArrayList;
import model.STUDENTS;
import repository.StudentsRepository;


public class StudentsServices {
    StudentsRepository ssr = new StudentsRepository();
    
    public ArrayList<STUDENTS> getListStudents(){
        return ssr.getStudentsDB();
    }
    
    public String addStudent(STUDENTS stu){
        return ssr.addStudentDB(stu);
    }
    
    public String removeStudent(STUDENTS stu){
        return ssr.removeStudentDB(stu);
    }
    
    public String updateStudent(STUDENTS stu){
        return ssr.updateStudentDB(stu);
    }
    
    public String getNameStudent(String maSV){
        return ssr.getNameStDB(maSV);
    }
}
