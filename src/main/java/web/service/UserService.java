package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void delete(int id);

    void update(int id, User user);

    void save(User user);
}
