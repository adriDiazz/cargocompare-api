package com.cargocompare.CargoCompare_api.user;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;

    private boolean isVerified;
    private String verificationCode;

    private boolean mfaEnabled;
    private String secret;

    @Enumerated(EnumType.STRING)
    Role role;


    @ManyToOne
    @JoinColumn(name = "empresas_logistica_id", nullable = true)
    private LogisticCompany logisticCompany;

    @ManyToOne
    @JoinColumn(name = "proveedor_id", nullable = true)
    private Supplier supplier;

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email ;
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
