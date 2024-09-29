package com.noureddine.commonlibrary.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
@Setter
@Table(name = "reporter")
public class Reporter extends User {




    @OneToMany(mappedBy = "reporter",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Report> reports= new ArrayList<>();


    @Embedded
    private Profile profile;


    public Reporter(UUID id, String email, String password, boolean active, LocalDateTime createdAt, LocalDateTime lastModifiedDate) {
        super(id, email, password, active, createdAt, lastModifiedDate);
    }

    @Override
    public UUID getId() {
        return super.getId();
    }


    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public boolean isActive() {
        return super.isActive();
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return super.getCreatedAt();
    }

    @Override
    public LocalDateTime getLastModifiedDate() {
        return super.getLastModifiedDate();
    }

    @Override
    public void setId(UUID id) {
        super.setId(id);
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        super.setCreatedAt(createdAt);
    }

    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        super.setLastModifiedDate(lastModifiedDate);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getAuthorities();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
}
