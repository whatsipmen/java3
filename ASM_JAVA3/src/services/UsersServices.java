
package services;

import model.USERS;
import repository.UsersRepository;


public class UsersServices {
    UsersRepository usr = new UsersRepository();
    public USERS checkLogin(String username, String password){
        return usr.getUsersDB(username, password);
    }
}
