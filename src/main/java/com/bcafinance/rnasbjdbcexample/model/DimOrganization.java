package com.bcafinance.rnasbjdbcexample.model;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 22/11/2022
@Last Modified 22/11/2022 13:13
Version 1.0
*/


public class DimOrganization {

    private long organizationkey;

    private String parentorganizationkey;

    private String percentageofownership;

    private String organizationname;

    private long currencykey;

    public DimOrganization() {
    }

    public DimOrganization(long organizationkey, String parentorganizationkey, String percentageofownership, String organizationname, long currencykey) {
        this.organizationkey = organizationkey;
        this.parentorganizationkey = parentorganizationkey;
        this.percentageofownership = percentageofownership;
        this.organizationname = organizationname;
        this.currencykey = currencykey;
    }

    public DimOrganization(String parentorganizationkey, String percentageofownership, String organizationname, long currencykey) {
        this.parentorganizationkey = parentorganizationkey;
        this.percentageofownership = percentageofownership;
        this.organizationname = organizationname;
        this.currencykey = currencykey;
    }

    public long getOrganizationkey() {
        return organizationkey;
    }

    public void setOrganizationkey(long OrganizationKey) {
        this.organizationkey = OrganizationKey;
    }

    public String getParentorganizationkey() {
        return parentorganizationkey;
    }

    public void setParentorganizationkey(String ParentOrganizationKey) {
        this.parentorganizationkey = ParentOrganizationKey;
    }

    public String getPercentageofownership() {
        return percentageofownership;
    }

    public void setPercentageofownership(String PercentageOfOwnership) {
        this.percentageofownership = PercentageOfOwnership;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String OrganizationName) {
        this.organizationname = OrganizationName;
    }

    public long getCurrencykey() {
        return currencykey;
    }

    public void setCurrencykey(long CurrencyKey) {
        this.currencykey = CurrencyKey;
    }
}
