
package repository;

import Repository.DBConnection;
import model.USERS;
import java.sql.*;

public class UsersRepository {
    ResultSet rs = null;
    Statement st = null;
    DBConnection dbcn;
    USERS user;
    public UsersRepository() {
        dbcn = new DBConnection();
    }
    
    
    public USERS getUsersDB(String username, String password){
        String select = "Select * from USERS where username = '" + username + "'" +  "and password = '" + password + "'";
        try{
            st = dbcn.openDBConnection().createStatement();
            rs = st.executeQuery(select);
            while (rs.next()){
                user = new USERS(rs.getNString(1),rs.getNString(2),rs.getNString(3));
            }
        }catch(Exception ex){
            
        }
        return user;
    }
}
