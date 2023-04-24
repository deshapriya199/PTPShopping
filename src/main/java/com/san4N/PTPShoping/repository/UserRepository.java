package com.san4N.PTPShoping.repository;

import com.san4N.PTPShoping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET u.status = 'ACTIVE' WHERE u.id=:userId AND u.status='NEW'")
    void activate(@Param("userId") Long userId);
}
