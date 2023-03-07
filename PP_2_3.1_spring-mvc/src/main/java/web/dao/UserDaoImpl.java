package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    @Override
    public List<User> getALLUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User userInfo(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(userInfo(id));
    }
}