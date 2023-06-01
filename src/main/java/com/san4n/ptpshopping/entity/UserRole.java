package com.san4n.ptpshopping.entity;

import com.san4n.ptpshopping.entity.common.BaseEntity;
import com.san4n.ptpshopping.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER_ROLES")
@SuperBuilder
public class UserRole extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;

    public static final Status STATUS_ACTIVE = Status.ACTIVE;
}
