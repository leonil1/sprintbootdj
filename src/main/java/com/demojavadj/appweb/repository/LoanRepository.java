package com.demojavadj.appweb.repository;

import com.demojavadj.appweb.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
