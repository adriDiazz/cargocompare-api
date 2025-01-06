package com.cargocompare.CargoCompare_api.companies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<LogisticCompany, Long> {
}
