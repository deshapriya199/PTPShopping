package com.san4N.PTPShoping.entity;

import com.san4N.PTPShoping.entity.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ROLES")
@Data
public class Role extends BaseEntity {

    private String name;
    private String description;
}
