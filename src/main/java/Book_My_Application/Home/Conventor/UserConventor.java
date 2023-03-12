package Book_My_Application.Home.Conventor;

import Book_My_Application.Home.DTOs.UserDTOs;
import Book_My_Application.Home.Entity.UserEntity;

public class UserConventor {

    public static UserEntity conUserDtoIntoEntity(UserDTOs userDTOs){
        UserEntity userEntity= UserEntity.builder().name(userDTOs.getName()).age(userDTOs.getAge()).mobNo(userDTOs.getMobNo())
                .Email_Id(userDTOs.getEmail_Id()).address(userDTOs.getAddress()).build();
        return userEntity;
    }
}
