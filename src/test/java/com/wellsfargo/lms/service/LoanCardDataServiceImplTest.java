package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.LoanCard;
import com.wellsfargo.lms.model.User;
import com.wellsfargo.lms.repository.LoanCardRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class LoanCardDataServiceImplTest {

    @Autowired
    LoanCardDataService loanCardDataService;
    @MockBean
    LoanCardRepository loanCardRepository;

    LoanCard loanCard;

    @BeforeEach
    void setUp() {
        loanCard = new LoanCard();
    }

    @AfterEach
    void tearDown() {
        loanCard = null;
    }

    @Test
    void addLoanCard() {
        loanCard = LoanCard.builder()
                .loanId("L0001")
                .loanType("Furniture")
                .loanDurationYrs(5)
                .build();

        String response = loanCardDataService.addLoanCard(loanCard);
        assertEquals("Loan Card added!", response);
    }

    @Test
    void getAllLoanCards() {
        loanCard = LoanCard.builder()
                .loanId("L0001")
                .loanType("Furniture")
                .loanDurationYrs(5)
                .build();

        LoanCard loanCard2 = LoanCard.builder()
                .loanId("L0002")
                .loanType("Stationery")
                .loanDurationYrs(2)
                .build();

        LoanCard loanCard3 = LoanCard.builder()
                .loanId("L0003")
                .loanType("Crockery")
                .loanDurationYrs(3)
                .build();

        List<LoanCard> result = new ArrayList<>();
        result.add(loanCard);
        result.add(loanCard2);
        result.add(loanCard3);

        when(loanCardRepository.findAll()).thenReturn(result);

        List<LoanCard> response = loanCardDataService.getAllLoanCards();
        assertEquals("L0001", response.get(0).getLoanId());
        assertEquals("L0002", response.get(1).getLoanId());
        assertEquals("L0003", response.get(2).getLoanId());
        assertEquals("Furniture", response.get(0).getLoanType());
        assertEquals("Stationery", response.get(1).getLoanType());
        assertEquals("Crockery", response.get(2).getLoanType());
        assertEquals(5, response.get(0).getLoanDurationYrs());
        assertEquals(2, response.get(1).getLoanDurationYrs());
        assertEquals(3, response.get(2).getLoanDurationYrs());
    }
}