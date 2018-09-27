package com.addressbook.service;

import com.addressbook.entity.Company;
import com.addressbook.entity.Employee;
import com.addressbook.entity.WorkPlace;

import java.util.List;

public interface WorkPlaceService {

    WorkPlace create(WorkPlace workPlace);
    List<Employee> findAllEmployeeByCompany(Company company);
    List<Company> findAllCompanyByEmployee(Employee employee);
    void delete(WorkPlace workPlace);

    WorkPlace findWorkPlaceById(Integer id);
}
