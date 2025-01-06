package com.cargocompare.CargoCompare_api.suppliers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateSupplierRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address must not exceed 200 characters")
    private String address;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Phone must be a valid number with 7 to 15 digits")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email format")
    private String email;

    @NotBlank(message = "Contact person is required")
    @Size(max = 100, message = "Contact person must not exceed 100 characters")
    private String contactPerson;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Contact phone must be a valid number with 7 to 15 digits")
    private String contactPhone;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Contact email must be a valid email format")
    private String contactEmail;

    @Size(max = 100, message = "Website must not exceed 100 characters")
    @Pattern(regexp = "^(https?:\\/\\/)?[\\w.-]+(\\.[a-z]{2,})+(:\\d+)?(\\/.*)?$", message = "Website must be a valid URL")
    private String webSite;

    @Size(max = 200, message = "Logo URL must not exceed 200 characters")
    private String logo;

    @NotBlank(message = "CIF is required")
    @Size(max = 20, message = "CIF must not exceed 20 characters")
    private String cif;

    @NotBlank(message = "Social reason is required")
    @Size(max = 100, message = "Social reason must not exceed 100 characters")
    private String socialReason;

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "^[0-9]{4,10}$", message = "Postal code must be between 4 and 10 digits")
    private String postalCode;

    @NotBlank(message = "City is required")
    @Size(max = 50, message = "City must not exceed 50 characters")
    private String city;

    @NotBlank(message = "Province is required")
    @Size(max = 50, message = "Province must not exceed 50 characters")
    private String province;

    @NotBlank(message = "Country is required")
    @Size(max = 50, message = "Country must not exceed 50 characters")
    private String country;

}
