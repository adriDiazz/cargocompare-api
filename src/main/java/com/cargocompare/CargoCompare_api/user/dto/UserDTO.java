package com.cargocompare.CargoCompare_api.user.dto;

import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.companies.dto.CompanyDTO;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierDTO;
import com.cargocompare.CargoCompare_api.user.State;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private State state;

    private boolean isVerified;
    Collection<SimpleGrantedAuthority> authorities;
    private CompanyDTO logisticCompany;
    private SupplierDTO supplier;


    public UserDTO(UUID id, String name, String email, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.email = email;
        this.authorities = (Collection<SimpleGrantedAuthority>) authorities;
    }
}
