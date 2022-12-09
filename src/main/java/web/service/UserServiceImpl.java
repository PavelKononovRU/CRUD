package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    UserDAO userDao;
    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void addUsers() {
        User Andrey = new User("Andrey", "Teplyakov", "Tepliy67@mail.ru", (byte) 28);
        User Nikita = new User("Nikita", "Promyschlennikov", "Promyh96@yandex.ru", (byte) 26);
        User Ignat = new User("Ignat", "Pestrin", "Pestriy@mail.ru", (byte) 33);
        User Matvey = new User("Matvey", "Valentinov", "valval35@mail.ru", (byte) 69);
        User Alexander = new User("Alexander", "Lyabuhov", "rybierybiy74@mail.ru", (byte) 48);
        userDao.save(Andrey);userDao.save(Nikita);userDao.save(Ignat);userDao.save(Matvey);userDao.save(Alexander);
    }
}
