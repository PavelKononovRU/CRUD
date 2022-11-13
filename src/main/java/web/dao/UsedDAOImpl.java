package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsedDAOImpl implements UserDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<User> findAll() {
        List<User> listUsers;
        listUsers = entityManager.createQuery("from User", User.class).getResultList();
        return listUsers;
    }

    @Override
    @Transactional
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        user = entityManager.find(User.class, id);
        entityManager.refresh(user);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }
}
