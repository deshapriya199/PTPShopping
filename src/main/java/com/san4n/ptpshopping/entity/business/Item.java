package com.san4n.ptpshopping.entity.business;

import com.san4n.ptpshopping.entity.common.BaseEntity;
import com.san4n.ptpshopping.entity.core.User;
import com.san4n.ptpshopping.enums.Catogery;
import com.san4n.ptpshopping.enums.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
public class Item extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Catogery catogery;

    private String name;

    private Double price;

    private User owner;

    private String imgUrl;

    public static final Status STATUS_ACTIVE = Status.ACTIVE;
}
