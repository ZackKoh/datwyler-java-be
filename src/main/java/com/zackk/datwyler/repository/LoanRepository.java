package com.zackk.datwyler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zackk.datwyler.models.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
