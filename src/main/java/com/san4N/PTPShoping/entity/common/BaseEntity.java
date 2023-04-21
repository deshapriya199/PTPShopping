package com.san4N.PTPShoping.entity.common;

import com.san4N.PTPShoping.common.dataType.Status;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long id;

    @CreationTimestamp
    private Timestamp createdTime;

    @UpdateTimestamp
    private Timestamp modTime;

    @Column(nullable = false)
    @Version
    private Integer modRev;

    private Status status;

    @PrePersist
    public void onPrePersist(){

    }

    @PreUpdate
    public void onPreUpdate() {

    }
}
