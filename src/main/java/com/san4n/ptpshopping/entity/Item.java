package com.san4n.ptpshopping.entity;

import com.san4n.ptpshopping.entity.common.BaseEntity;
import com.san4n.ptpshopping.enums.Status;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Item extends BaseEntity {

    public static final Status STATUS_ACTIVE = Status.ACTIVE;
}
