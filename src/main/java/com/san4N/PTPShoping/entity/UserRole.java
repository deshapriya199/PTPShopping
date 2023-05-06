package com.san4N.PTPShoping.entity;

import com.san4N.PTPShoping.entity.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER_ROLES")
@Data
public class UserRole extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;
}
