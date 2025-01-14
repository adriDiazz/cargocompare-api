package com.cargocompare.CargoCompare_api.suppliers;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.suppliers.dto.CreateSupplierRequest;
import com.cargocompare.CargoCompare_api.suppliers.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiVersion.API_PATH + "/suppliers")
public class SuppliersController {

    private final SupplierService supplierService;

    public SuppliersController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Supplier> createSupplier(
            @RequestBody  @Valid CreateSupplierRequest supplierRequest
            ) {
        return ResponseEntity.ok(supplierService.createSupplier(supplierRequest));
    }

    @PostMapping("/company/{companyId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Supplier> createSupplierForCompany(
            @RequestBody  @Valid CreateSupplierRequest supplierRequest,
            @PathVariable Long companyId
    ) {
        return ResponseEntity.ok(supplierService.createSupplierForCompany(supplierRequest, companyId));
    }

}
