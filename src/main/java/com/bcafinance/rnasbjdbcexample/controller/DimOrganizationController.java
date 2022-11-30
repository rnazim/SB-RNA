package com.bcafinance.rna.sbjdbcexample.controller;/*
Created By IntelliJ IDEA 2022.2.3 (Comunity Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Azim a.k.a. Azim
Java Developer
Create on 22/11/2022
@Last Modified 22/11/2022 13:15
Version 1.0
*/

import com.bcafinance.rna.sbjdbcexample.model.DimOrganization;
import com.bcafinance.rna.sbjdbcexample.repository.DimOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class DimOrganizationController {

    @Autowired
    DimOrganizationRepository dimOrganizationRepository;

    @GetMapping("/dimorganizations/{id}")
    public ResponseEntity<DimOrganization> getDimOrganiztionById(@PathVariable("id") long id) {
        DimOrganization dimOrganization = dimOrganizationRepository.findById(id);

        if (dimOrganization != null) {
            return new ResponseEntity<>(dimOrganization, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dimorganizations")
    public ResponseEntity<String> createDimOrganization(@RequestBody DimOrganization dimOrganization){
        try{
            if (dimOrganization != null) {
                dimOrganizationRepository.save(new DimOrganization(dimOrganization.getParentorganizationkey(),
                        dimOrganization.getPercentageofownership(),
                        dimOrganization.getOrganizationname(),
                        dimOrganization.getCurrencykey()));
                return new ResponseEntity<>("Data Berhasil Ditambahkan.",HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e){
            System.out.println("MASUK KESINI : "+e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dimorganizations/{id}")
    public ResponseEntity<String> updateDimOrganization(@PathVariable("id") long id, @RequestBody DimOrganization dimOrganization){
        DimOrganization _dimOrganization = dimOrganizationRepository.findById(id);

        if (_dimOrganization !=null){
            _dimOrganization.setOrganizationkey(id);
            _dimOrganization.setParentorganizationkey(dimOrganization.getParentorganizationkey());
            _dimOrganization.setPercentageofownership(dimOrganization.getPercentageofownership());
            _dimOrganization.setOrganizationname(dimOrganization.getOrganizationname());
            _dimOrganization.setCurrencykey(dimOrganization.getCurrencykey());

            dimOrganizationRepository.update(_dimOrganization);
            return new ResponseEntity<>("Data Berhasil diubah.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Data tidak Ditemukan!! id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dimorganizations/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        try {
            int result = dimOrganizationRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Data dengan id " + id +" Tidak Ditemukan !!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id "+id+" Berhasil di hapus", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}