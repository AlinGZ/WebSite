package licenta.repository.interfaces;

import java.util.List;
import licenta.entity.User;

public interface UserDao {
    
    void insertUser(User u);
    void deleteUserById(int id);
    int getLatestUserId();
    User getUserByName(String name);
    User getUserById(int id);
    List<User> listUsers();
    
}
