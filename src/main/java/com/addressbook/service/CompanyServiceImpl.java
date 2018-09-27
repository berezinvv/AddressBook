package com.addressbook.service;

import com.addressbook.entity.Company;
import com.addressbook.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company create(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Integer id) {
        return companyRepository.getOne(id);
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }

}
