package service.userService;

import service.dao.UsersDao;
import service.users.Users;
import service.utils.Utils;

public class UserService {
//private Utils utils;
    public UserService() {
        //utils = new Utils();
    }

    public long addUser(String login, String pass) {
        UsersDao usersDao = new UsersDao();
        return usersDao.insertUser(login, pass);
    }

    public Users getUserById(long id) {
        UsersDao usersDao = new UsersDao();
        return usersDao.getUsers(id);
    }
    public Users getUsersByLogin(String login){
        UsersDao usersDao = new UsersDao();
        return usersDao.getUsersByLogin(login);
    }

}
