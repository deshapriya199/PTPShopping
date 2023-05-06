package com.san4N.PTPShoping.repository;

import com.san4N.PTPShoping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET" +
            " u.status = com.san4N.PTPShoping.enums.Status.ACTIVE" +
            " WHERE " +
            "u.id=:userId AND" +
            " u.status = com.san4N.PTPShoping.enums.Status.NEW")
    int activateUser(@Param("userId") Long userId);

    Optional<User> findByUserName(String username);
}
