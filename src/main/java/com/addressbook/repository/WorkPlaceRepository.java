package com.addressbook.repository;

import com.addressbook.entity.Company;
import com.addressbook.entity.Employee;
import com.addressbook.entity.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlace, Integer> {

    List<Company> findAllByEmployee(Employee employee);

    List<Employee> findAllByCompany(Company company);

}
