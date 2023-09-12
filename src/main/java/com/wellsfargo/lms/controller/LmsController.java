package com.wellsfargo.lms.controller;

import com.wellsfargo.lms.model.Employee;
import com.wellsfargo.lms.model.LoanCard;
import com.wellsfargo.lms.model.User;
import com.wellsfargo.lms.service.EmployeeDataService;
import com.wellsfargo.lms.service.LoanCardDataService;
import com.wellsfargo.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LmsController {

    @Autowired
    UserService userService;
    @Autowired
    EmployeeDataService employeeDataService;

    @Autowired
    LoanCardDataService loanCardDataService;

    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to LMS";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User userDto) {
        return userService.saveUser(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User userDto) {
        User user = userService.login(userDto);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

    }

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee empDto) {
        return employeeDataService.addEmployee(empDto);
    }

    @PostMapping("/addLoanCardDetails")
    public String addLoanCardDetails(@RequestBody LoanCard loanCardDto)
    {
        return loanCardDataService.addLoanCard(loanCardDto);
    }

    @GetMapping("/getAllLoanCards")
    public ResponseEntity<List<LoanCard>> getAllLoanCards()
    {
        List<LoanCard> loanCards = loanCardDataService.getAllLoanCards();

        return new ResponseEntity<>(loanCards, HttpStatus.OK);
    }
}
