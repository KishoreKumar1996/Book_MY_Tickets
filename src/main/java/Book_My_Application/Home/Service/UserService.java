package Book_My_Application.Home.Service;

import Book_My_Application.Home.Conventor.UserConventor;
import Book_My_Application.Home.DTOs.UserDTOs;
import Book_My_Application.Home.Entity.UserEntity;
import Book_My_Application.Home.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public UserEntity addUser(UserDTOs userDTOs)throws Exception{
        //create one user obj and set the values
     // old method is to set the attributes of an obj

        //new methods is builder is easily for developer

//   UserEntity userEntity= UserEntity.builder().name(userDTOs.getName()).age(userDTOs.getAge()).mobNo(userDTOs.getMobNo()).Email_Id(userDTOs.getEmail_Id()).address(userDTOs.getAddress()).build();
       UserEntity userEntity= UserConventor.conUserDtoIntoEntity(userDTOs);
       userRepo.save(userEntity);
        return userEntity;
    }
}
