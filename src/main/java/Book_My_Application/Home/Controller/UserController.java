package Book_My_Application.Home.Controller;

import Book_My_Application.Home.DTOs.UserDTOs;
import Book_My_Application.Home.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/user_in")
    public ResponseEntity<String> addUser (UserDTOs userDTOs)throws Exception{
      try{
          userService.addUser(userDTOs);
          return new ResponseEntity<>("successfully added",HttpStatus.CREATED );
      }catch(Exception e){
         return new ResponseEntity<>("Not able to Added",HttpStatus.BAD_REQUEST);
      }
    }
}
