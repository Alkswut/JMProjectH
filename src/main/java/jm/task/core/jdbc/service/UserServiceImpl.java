package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

    public UserServiceImpl() {

    }

    public void createUsersTable() throws SQLException {
        userDaoHibernate.createUsersTable();

    }

    public void dropUsersTable() throws SQLException {
        userDaoHibernate.dropUsersTable();
        //userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDaoHibernate.saveUser(name, lastName, age);
        //userDaoJDBC.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) throws SQLException {
        userDaoHibernate.removeUserById(id);
        // userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDaoHibernate.getAllUsers();
        // return userDaoJDBC.getAllUsers();
        // return null;
    }

    public void cleanUsersTable() throws SQLException {
        userDaoHibernate.cleanUsersTable();
        // userDaoJDBC.cleanUsersTable();
    }
}
