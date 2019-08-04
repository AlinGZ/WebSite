package licenta.controller;

import java.util.List;
import java.util.Map;
import licenta.entity.User;
import licenta.util.RequestException;
import licenta.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping(value ="/add")
    public void insertUser(@RequestBody Map<String,String> body) {
        User user = new User(body.get("last_name"), body.get("first_name"), body.get("gender"),Integer.parseInt(body.get("age")),Double.valueOf(body.get("salary")), Double.valueOf(body.get("loaned_sum")), Integer.parseInt(body.get("period")), Double.valueOf(body.get("interest_rate")), Double.valueOf(body.get("DAE")), Double.valueOf(body.get("monthly_payment")), Double.valueOf(body.get("total_amount")), Integer.parseInt(body.get("score")), body.get("eligibility"));
        this.userService.insertUser(user);
    }
    
    @GetMapping(value = "/list")
    public List<User> listUsers() {
        return this.userService.listUsers();
    }
    
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") int id) {
        if(this.userService.getUserById(id) != null)
            return this.userService.getUserById(id);
        else
            throw new RequestException(HttpStatus.BAD_REQUEST, "User doesn't exist!");
    }
    
    @GetMapping(value = "/latest")
    public User getLatestUser() {
            return this.userService.getUserById(userService.getLatestUserId());
    }
    
    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id) {
        if(this.userService.getUserById(id) != null) {
            this.userService.deleteUserById(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        else
            throw new RequestException(HttpStatus.BAD_REQUEST, "Invalid user!");
    }
    
    @ExceptionHandler(RequestException.class)
    public ResponseEntity handleException(RequestException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    }
}
