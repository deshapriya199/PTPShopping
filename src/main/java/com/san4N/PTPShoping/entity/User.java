package com.san4N.PTPShoping.entity;

import com.san4N.PTPShoping.entity.common.BaseEntity;
import com.san4N.PTPShoping.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true, length = 100)
    private String userName;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRole;

    public static final Status STATUS_NEW = Status.NEW;
    public static final Status STATUS_PENDING_REGISTRATION = Status.PENDING_REGISTRATION;
    public static final Status STATUS_ACTIVE = Status.ACTIVE;
    public static final Status STATUS_DISABLE = Status.DISABLE;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return STATUS_DISABLE.equals(getStatus());
    }
}
