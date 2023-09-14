package com.wellsfargo.lms.service;

import com.wellsfargo.lms.model.LoanCard;
import com.wellsfargo.lms.repository.LoanCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanCardDataServiceImpl implements LoanCardDataService{

    @Autowired
    LoanCardRepository loanCardRepository;

    @Override
    public String addLoanCard(LoanCard loanCard)
    {
        try
        {
            loanCardRepository.save(loanCard);
            return "Loan Card added!";
        }
        catch(Exception e)
        {
            return "Unable to add loan card!: " + e.getMessage();
        }

    }

    @Override
    public List<LoanCard> getAllLoanCards() {
        try
        {
            return loanCardRepository.findAll();
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
