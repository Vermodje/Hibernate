package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import users.Users;
import utils.Utils;


public class UsersDao {
    private Session session;
    private SessionFactory sessionFactory;
    private Utils utils;

    public UsersDao() {
        utils = new Utils();
        sessionFactory = utils.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public long insertUser(String login, String password) {
        Transaction transaction = session.beginTransaction();
        long id = (Long) session.save(new Users(login, password));
        transaction.commit();

        return id;
    }

    public Users getUsers(long id) {
        Users users = (Users) session.get(Users.class, id);

        return users;
    }

    public Users getUsersByLogin(String login) {
        Criteria criteria = session.createCriteria(Users.class);
        Users users = ((Users) criteria.add(Restrictions.eq("login", login)).uniqueResult());

        return users;
    }

}
