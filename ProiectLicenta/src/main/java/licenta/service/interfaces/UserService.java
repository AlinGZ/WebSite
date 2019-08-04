package licenta.service.interfaces;

import java.util.List;
import licenta.entity.User;

public interface UserService {
    
    void insertUser(User u);
    void deleteUserById(int id);
    int getLatestUserId();
    User getUserByName(String name);
    User getUserById(int id);
    List<User> listUsers();
}
