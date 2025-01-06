package com.cargocompare.CargoCompare_api.supplierCompany;

import com.cargocompare.CargoCompare_api.commons.entities.SupplierCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierCompanyRepository extends JpaRepository<SupplierCompany, Long> {
}
