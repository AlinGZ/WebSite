package licenta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import licenta.entity.User;
import licenta.repository.interfaces.UserDao;
import licenta.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDAO;
    
    @Override
    @Transactional
    public void insertUser(User u) {
            this.userDAO.insertUser(u);
    }
    
    @Override
    public List<User> listUsers() {
        return this.userDAO.listUsers();
    }
    
    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        this.userDAO.deleteUserById(id);
    }
    
     @Override
    public User getUserByName(String name) {
        return this.userDAO.getUserByName(name);
    }
    
    public int getLatestUserId() { return this.userDAO.getLatestUserId(); }
}
