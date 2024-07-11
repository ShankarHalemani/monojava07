package com.techlabs.model;

import com.techlabs.exceptions.DuplicateSupplierException;
import com.techlabs.exceptions.InvalidSupplierIdException;

import java.util.*;

public class SupplierManager implements SupplierManagement{
    Map<String, Supplier> supplierMap = new HashMap<>();
    @Override
    public void addSupplier(Supplier supplier) {
        if(supplierMap.containsKey(supplier.getSupplierId())){
            throw new DuplicateSupplierException("Supplier ID already exists");
        }
        supplierMap.put(supplier.getSupplierId(),supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        if(!supplierMap.containsKey(supplier.getSupplierId())){
            throw new InvalidSupplierIdException("Supplier ID not found");
        }
        supplierMap.put(supplier.getSupplierId(), supplier);
    }

    @Override
    public void deleteSupplier(String supplierId) {
        if(!supplierMap.containsKey(supplierId)){
            throw new InvalidSupplierIdException("Supplier ID not found");
        }
        supplierMap.remove(supplierId);

    }

    @Override
    public Supplier getSupplier(String supplierId) {
        return supplierMap.get(supplierId);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>(supplierMap.values());
    }
}
