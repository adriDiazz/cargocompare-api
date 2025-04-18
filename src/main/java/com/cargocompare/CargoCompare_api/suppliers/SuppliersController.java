package com.cargocompare.CargoCompare_api.suppliers;

import com.cargocompare.CargoCompare_api.commons.constants.ApiVersion;
import com.cargocompare.CargoCompare_api.suppliers.dto.CreateSupplierRequest;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierDTO;
import com.cargocompare.CargoCompare_api.suppliers.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<SupplierDTO>> getSuppliers() {
        return ResponseEntity.ok(supplierService.getSuppliers());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(supplierService.getSupplierById(id));
    }

    @GetMapping("/company/{companyId}/supplier/{supplierId}")
    public ResponseEntity<SupplierDTO> getSupplierByCompanyIdAndSupplierId(
            @PathVariable Long companyId,
            @PathVariable Long supplierId
    ) {
        return ResponseEntity.ok(supplierService.getSupplierByCompanyIdAndSupplierId(companyId, supplierId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<SupplierDTO> updateSupplier(
            @PathVariable Long id,
            @RequestBody @Valid CreateSupplierRequest supplierRequest
    ) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, supplierRequest));
    }

}
