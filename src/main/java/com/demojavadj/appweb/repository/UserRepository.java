package com.demojavadj.appweb.repository;

import com.demojavadj.appweb.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
