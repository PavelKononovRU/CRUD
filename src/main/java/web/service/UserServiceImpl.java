package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UsedDAOImpl;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    final private UsedDAOImpl userDaoImpl;
    @Autowired
    public UserServiceImpl(UsedDAOImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public List<User> findAll() {
        return userDaoImpl.findAll();
    }

    @Override
    public User findById(int id) {
        return userDaoImpl.findById(id);
    }

    @Override
    public void delete(int id) {
        userDaoImpl.delete(id);
    }

    @Override
    public void update(int id, User user) {
        userDaoImpl.update(id, user);
    }

    @Override
    public void save(User user) {
        userDaoImpl.save(user);
    }
}
