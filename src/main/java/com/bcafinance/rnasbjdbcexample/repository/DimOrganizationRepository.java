package com.bcafinance.rnasbjdbcexample.repository;

import com.bcafinance.rnasbjdbcexample.model.DimOrganization;

import java.util.List;


public interface DimOrganizationRepository {
    int save(DimOrganization doz);

    int update(DimOrganization doz);

    DimOrganization findById(long id);
    int deleteById(long id);
    List<DimOrganization> findAll();
}
