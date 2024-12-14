package com.cargocompare.CargoCompare_api.commons.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isVerified;
    @Enumerated(EnumType.STRING)
    Rol.Roles role;

    @ManyToOne
    @JoinColumn(name = "empresas_logistica_id", nullable = true)
    private LogisticCompany logisticCompany;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = true)
    private Supplier supplier;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name + " " + lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // or your custom logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // or your custom logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // or your custom logic
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
