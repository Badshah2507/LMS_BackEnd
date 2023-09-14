package com.wellsfargo.lms.controller;

import com.wellsfargo.lms.model.Employee;

import com.wellsfargo.lms.model.Item;
import com.wellsfargo.lms.service.ItemDataService;

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
import java.util.Map;

@RestController
@RequestMapping
public class LmsController {

    @Autowired
    UserService userService;
    @Autowired
    EmployeeDataService employeeDataService;
    @Autowired
    ItemDataService itemDataService;

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
    public ResponseEntity<Map<String, String>> login(@RequestBody User userDto) {
        Map<String, String> user = userService.login(userDto);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }

    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee empDto) {
        String response = employeeDataService.addEmployee(empDto);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addItem")
    public String addItem(@RequestBody Item itemDto) { return itemDataService.addItemData(itemDto); }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> response = itemDataService.getAllItems();
        return new ResponseEntity<>(response, HttpStatus.OK);
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
