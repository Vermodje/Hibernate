package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import user.User;
import util.Util;


public class UsersDao {
    private Session session;

    public UsersDao() {
        Util util = new Util();
        SessionFactory sessionFactory = util.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public void insertUser(String login, String password) {
        Transaction transaction = session.beginTransaction();
        session.save(new User(login, password));
        transaction.commit();
    }

    public User getUser(long id) {
        return (User) session.get(User.class, id);
    }

    public User getUsersByLogin(String login) {
        Criteria criteria = session.createCriteria(User.class);
        return ((User) criteria.add(Restrictions.eq("login", login)).uniqueResult());
    }

}
