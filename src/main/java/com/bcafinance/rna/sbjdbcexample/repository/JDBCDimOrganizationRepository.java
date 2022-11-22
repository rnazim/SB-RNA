package com.bcafinance.rna.sbjdbcexample.repository;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 22/11/2022
@Last Modified 22/11/2022 13:50
Version 1.0
*/

import com.bcafinance.rna.sbjdbcexample.model.DimOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JDBCDimOrganizationRepository implements DimOrganizationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;



    @Override
    public int save(DimOrganization doz) {
        return jdbcTemplate.update("INSERT INTO DimOrganization(ParentOrganizationKey, PercentageOfOwnership, OrganizationName, CurrencyKey) VALUES (?,?,?,?)",
                new Object[]{
                        doz.getParentorganizationkey(),
                        doz.getPercentageofownership(),
                        doz.getOrganizationname(),
                        doz.getCurrencykey()
                });
    }

    @Override
    public int update(DimOrganization doz) {
        return jdbcTemplate.update("UPDATE DimOrganization SET ParentOrganizationKey=?, PercentageOfOwnership=?, OrganizationName=?, CurrencyKey=? WHERE OrganizationKey=?",
                new Object[]{
                        doz.getParentorganizationkey(),
                        doz.getPercentageofownership(),
                        doz.getOrganizationname(),
                        doz.getCurrencykey(),
                        doz.getOrganizationkey()
                });
    }


    @Override
    public DimOrganization findById(long id) {
        try{
            DimOrganization dimOrganization = jdbcTemplate.queryForObject("SELECT * FROM DimOrganization WHERE OrganizationKey=?",
                    BeanPropertyRowMapper.newInstance(DimOrganization.class), id);

            return dimOrganization;
        } catch (
                Exception e) {
            return null;
        }
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM DimOrganization WHERE OrganizationKey=?", id);
    }

    @Override
    public List<DimOrganization> findAll() {
        return null;
    }
}
