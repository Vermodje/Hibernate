package userService;

import dao.UsersDao;
import users.Users;

public class UserService {

    private UsersDao usersDao = new UsersDao();

    public UserService() {

    }

    public long addUser(String login, String password) {

        return usersDao.insertUser(login, password);
    }

    public Users getUserById(long id) {

        return usersDao.getUsers(id);
    }

    public Users getUsersByLogin(String login) {

        return usersDao.getUsersByLogin(login);
    }

}
