package com.san4N.PTPShoping.entity;

import com.san4N.PTPShoping.entity.common.BaseEntity;
import com.san4N.PTPShoping.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 100)
    private String userName;

    @Column(nullable = false)
    private String password;

    public static final Status STATUS_NEW = Status.NEW;
    public static final Status STATUS_PENDING_REGISTRATION = Status.PENDING_REGISTRATION;
    public static final Status STATUS_ACTIVE = Status.ACTIVE;
    public static final Status STATUS_DISABLE = Status.DISABLE;
}
