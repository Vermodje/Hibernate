package userService;

import dao.UsersDao;
import user.User;

public class UserService {

    private UsersDao usersDao = new UsersDao();

    public UserService() {

    }

    public void addUser(String login, String password) {

        usersDao.insertUser(login, password);
    }

    public User getUserById(long id) {

        return usersDao.getUser(id);
    }

    public User getUsersByLogin(String login) {

        return usersDao.getUsersByLogin(login);
    }

}
