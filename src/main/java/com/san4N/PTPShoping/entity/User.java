package com.san4N.PTPShoping.entity;

import com.san4N.PTPShoping.common.dataType.Status;
import com.san4N.PTPShoping.entity.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(nullable = false, length = 255)
    private String password;

    public static final Status NEW = Status.valueOf("New");
}
