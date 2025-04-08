package com.cargocompare.CargoCompare_api.suppliers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuppliersRepository extends JpaRepository<Supplier, Long> {
    @Query("""
    SELECT sp
    FROM Supplier sp
    LEFT JOIN FETCH sp.companySuppliers sc
    LEFT JOIN FETCH sc.logisticCompany lc
    WHERE sp.id = :supplierId AND lc.id = :companyId
""")
    Optional<Supplier> findSupplierByCompanyId(@Param("companyId") Long companyId, @Param("supplierId") Long supplierId);

}
