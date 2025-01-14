package com.cargocompare.CargoCompare_api.companies.exceptions;

public class CompanyNotFoundError extends RuntimeException {
    public CompanyNotFoundError(String message) {
        super(message);
    }
}
