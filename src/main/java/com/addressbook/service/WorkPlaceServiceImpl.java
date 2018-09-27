package com.addressbook.service;

import com.addressbook.entity.Company;
import com.addressbook.entity.Employee;
import com.addressbook.entity.WorkPlace;
import com.addressbook.repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkPlaceServiceImpl implements WorkPlaceService {

    @Autowired
    private WorkPlaceRepository workPlaceRepository;

    public WorkPlace create(WorkPlace workPlace) {
        return workPlaceRepository.save(workPlace);
    }

    public List<Employee> findAllEmployeeByCompany(Company company) {
        return workPlaceRepository.findAllByCompany(company);
    }

    public List<Company> findAllCompanyByEmployee(Employee employee) {
        return workPlaceRepository.findAllByEmployee(employee);
    }

    @Override
    public void delete(WorkPlace workPlace) {
        workPlaceRepository.delete(workPlace);
    }

    @Override
    public WorkPlace findWorkPlaceById(Integer id) {
        return workPlaceRepository.getOne(id);
    }
}
