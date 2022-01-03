package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.JmusersEntity;
import jm.task.core.jdbc.UsersEntity;
import org.hibernate.*;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;


import java.util.List;

import static jm.task.core.jdbc.util.HibernateUtil.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    Transaction transaction = null;

    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        transaction = session.beginTransaction();

        String sql = "CREATE TABLE IF NOT EXISTS USERS" +
                "(ID BIGINT not null AUTO_INCREMENT, " +
                "name VARCHAR(255), " +
                "lastName VARCHAR(255), " +
                "age TINYINT, " +
                "PRIMARY KEY(ID))";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();

        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        transaction = session.beginTransaction();

        String sql = "DROP TABLE IF EXISTS USERS";

        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = getSessionFactory().openSession();
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        Query query = null;
        try {
            Session session = getSessionFactory().openSession();
            query = session.createQuery("SELECT * FROM JMUsers");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return query.list();
    }

    @Override
    public void cleanUsersTable() {

    }
}
