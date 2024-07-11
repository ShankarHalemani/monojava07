package com.techlabs.model;

import java.util.List;

public interface SupplierManagement {
    void addSupplier(Supplier supplier);
    void updateSupplier(Supplier supplier);
    void deleteSupplier(String supplierId);
    Supplier getSupplier(String supplierId);
    List<Supplier> getAllSuppliers();
}
