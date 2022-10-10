package com.zackk.datwyler.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.zackk.datwyler.models.Loan;
import com.zackk.datwyler.repository.LoanRepository;

import java.net.URISyntaxException;
import java.net.URI;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

  private final LoanRepository loanRepository;

  public LoanController(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity createLoan(@RequestBody Loan loan) throws URISyntaxException {
    Loan savedLoan = loanRepository.save(loan);
    return ResponseEntity.created(new URI("/api/loans" + savedLoan.getId())).body(savedLoan);
  }

}
