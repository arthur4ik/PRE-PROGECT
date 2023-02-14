package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        // userDaoHibernate.dropUsersTable();
        //userDaoHibernate.createUsersTable();
        //userDaoHibernate.saveUser("ivan", "ivanov", (byte) 25);
        //userDaoHibernate.removeUserById(28);
        //List<User> users = userDaoHibernate.getAllUsers();
        //System.out.println(users);
        userDaoHibernate.cleanUsersTable();
    }
}
