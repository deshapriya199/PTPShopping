package com.san4N.PTPShoping.repository;

import com.san4N.PTPShoping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
