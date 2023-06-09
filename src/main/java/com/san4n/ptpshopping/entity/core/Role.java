package com.san4n.ptpshopping.entity.core;

import com.san4n.ptpshopping.entity.common.BaseEntity;
import com.san4n.ptpshopping.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ROLES")
@Data
@SuperBuilder
@NoArgsConstructor
public class Role extends BaseEntity {

    private String name;
    private String description;

    public static final Status STATUS_ACTIVE = Status.ACTIVE;
}
