package com.roomy.shop.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "shop")
@Data
public class User implements UserDetails {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "users_local_seq", sequenceName = "\"users_id_seq\"", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_local_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, length = 100, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false, name = "createdat")
    //@Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updatedat")
    //@Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }
}
