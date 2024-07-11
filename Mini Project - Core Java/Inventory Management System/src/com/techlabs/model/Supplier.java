package com.techlabs.model;

import java.io.Serializable;

public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    private String supplierId;
    private String supplierName;
    private String supplierContactInfo;

    public Supplier(String supplierId, String supplierName, String supplierContactInfo) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierContactInfo = supplierContactInfo;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierContactInfo() {
        return supplierContactInfo;
    }

    public void setSupplierContactInfo(String supplierContactInfo) {
        this.supplierContactInfo = supplierContactInfo;
    }

    @Override
    public String toString() {
        return "\n" +
                "Supplier Id : " + supplierId + '\n' +
                "Supplier Name : " + supplierName + '\n' +
                "Supplier Contact Information : " + supplierContactInfo + '\n';
    }
}
