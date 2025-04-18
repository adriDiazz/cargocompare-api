package com.cargocompare.CargoCompare_api.suppliers.service;

import com.cargocompare.CargoCompare_api.commons.entities.SupplierCompany;
import com.cargocompare.CargoCompare_api.companies.CompaniesRepository;
import com.cargocompare.CargoCompare_api.companies.LogisticCompany;
import com.cargocompare.CargoCompare_api.suppliers.Supplier;
import com.cargocompare.CargoCompare_api.supplierCompany.SupplierCompanyRepository;
import com.cargocompare.CargoCompare_api.suppliers.SuppliersRepository;
import com.cargocompare.CargoCompare_api.suppliers.dto.CreateSupplierRequest;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierDTO;
import com.cargocompare.CargoCompare_api.suppliers.dto.SupplierMapper;
import com.cargocompare.CargoCompare_api.suppliers.exceptions.CreatingSupplierError;
import com.cargocompare.CargoCompare_api.suppliers.exceptions.SupplierNotFoundError;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SuppliersRepository suppliersRepository;
    private final SupplierCompanyRepository supplierCompanyRepository;
    private final CompaniesRepository companiesRepository;

    public SupplierServiceImpl(SuppliersRepository suppliersRepository, SupplierCompanyRepository supplierCompanyRepository, CompaniesRepository companiesRepository) {
        this.suppliersRepository = suppliersRepository;
        this.supplierCompanyRepository = supplierCompanyRepository;
        this.companiesRepository = companiesRepository;
    }


    @Override
    public Supplier createSupplier(CreateSupplierRequest supplierRequest) {
        return Optional.of(supplierRequest)
                .map(SupplierMapper::toSupplier)
                .map(suppliersRepository::save)
                .orElseThrow(() -> new CreatingSupplierError("Error al crear el proveedor"));
    }

    @Override
    @Transactional(rollbackOn = CreatingSupplierError.class)
    public Supplier createSupplierForCompany(CreateSupplierRequest supplierRequest, Long companyId) {

        Supplier supplier = SupplierMapper.toSupplier(supplierRequest);

        supplier = suppliersRepository.save(supplier);

        LogisticCompany logisticCompany = companiesRepository.findById(companyId)
                .orElseThrow(() -> new CreatingSupplierError("La compañía con ID " + companyId + " no fue encontrada"));

        SupplierCompany relation = SupplierCompany.builder()
                .logisticCompany(logisticCompany)
                .supplier(supplier)
                .tariffId((long) -1)
                .build();

        supplierCompanyRepository.save(relation);

        return supplier;
    }

    @Override
    public List<SupplierDTO> getSuppliers() {
        return suppliersRepository.findAll().stream()
                .map(SupplierMapper::toSupplierDTO)
                .toList();
    }

    @Override
    public SupplierDTO getSupplierById(Long id) {
        return suppliersRepository.findById(id)
                .map(SupplierMapper::toSupplierDTO)
                .orElseThrow(() -> new SupplierNotFoundError("Proveedor no encontrado"));
    }

    @Override
    public SupplierDTO getSupplierByCompanyIdAndSupplierId(Long companyId, Long supplierId) {
        return suppliersRepository.findSupplierByCompanyId(companyId, supplierId)
                .map(SupplierMapper::toSupplierDTO)
                .orElseThrow(() -> new SupplierNotFoundError("Proveedor no encontrado"));
    }

    @Override
    public void deleteSupplier(Long id) {
        var supplier = suppliersRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundError("El proveedor con ID " + id + " no fue encontrado"));

        suppliersRepository.delete(supplier);
    }

    @Override
    public SupplierDTO updateSupplier(Long id, CreateSupplierRequest supplierRequest) {
        return suppliersRepository.findById(id)
                .map(supplier -> {
                    supplier.setName(supplierRequest.getName());
                    supplier.setAddress(supplierRequest.getAddress());
                    supplier.setPhone(supplierRequest.getPhone());
                    supplier.setEmail(supplierRequest.getEmail());
                    supplier.setCif(supplierRequest.getCif());
                    supplier.setCity(supplierRequest.getCity());
                    supplier.setCountry(supplierRequest.getCountry());
                    supplier.setDescription(supplierRequest.getDescription());
                    supplier.setContactEmail(supplierRequest.getContactEmail());
                    supplier.setContactPerson(supplierRequest.getContactPerson());
                    supplier.setContactPhone(supplierRequest.getContactPhone());
                    supplier.setLogo(supplierRequest.getLogo());
                    supplier.setPostalCode(supplierRequest.getPostalCode());
                    supplier.setProvince(supplierRequest.getProvince());
                    supplier.setSocialReason(supplierRequest.getSocialReason());
                    supplier.setWebSite(supplierRequest.getWebSite());
                    return suppliersRepository.save(supplier);
                })
                .map(SupplierMapper::toSupplierDTO)
                .orElseThrow(() -> new SupplierNotFoundError("Proveedor no encontrado"));
    }


}
