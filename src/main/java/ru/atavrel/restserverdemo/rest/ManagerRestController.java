package ru.atavrel.restserverdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.atavrel.restserverdemo.model.User;
import ru.atavrel.restserverdemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/manager/users")
@CrossOrigin(value = "http://localhost:8080")
public class ManagerRestController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // GET: http://localhost:8075/api/manager/users
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
