package com.addressbook.service;

import com.addressbook.entity.Company;

import java.util.List;

public interface CompanyService {

    Company create(Company company);

    List<Company> findAll();

    Company findCompanyById(Integer id);

    void delete(Company company);
}
