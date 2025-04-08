package com.cargocompare.CargoCompare_api.suppliers.exceptions;

public class SupplierNotFoundError extends RuntimeException {
    public SupplierNotFoundError(String message) {
        super(message);
    }
}
