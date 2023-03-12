package Book_My_Application.Home.Controller;

import Book_My_Application.Home.DTOs.ShowDTOs;
import Book_My_Application.Home.Entity.ShowEntity;
import Book_My_Application.Home.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/shows")
    public ResponseEntity<String> shows(@RequestBody ShowDTOs showDTOs){
        showService.showAdd(showDTOs);
        return new ResponseEntity<>("Successfully get ticket", HttpStatus.CREATED);
    }
}
