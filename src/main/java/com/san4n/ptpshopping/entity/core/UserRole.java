package com.san4n.ptpshopping.entity.core;

import com.san4n.ptpshopping.entity.common.BaseEntity;
import com.san4n.ptpshopping.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "USER_ROLES")
@SuperBuilder
@Data
@NoArgsConstructor
public class UserRole extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USERID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ROLEID")
    private Role role;

    public static final Status STATUS_ACTIVE = Status.ACTIVE;
}
