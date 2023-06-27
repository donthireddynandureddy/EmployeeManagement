package com.employee.management.service;

import com.employee.management.entity.EmployeeManagement;
import com.employee.management.repository.EmployeeManagementRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManagementService {

    private final EmployeeManagementRepository repository;

    public EmployeeManagementService(EmployeeManagementRepository repository) {
        this.repository = repository;
    }

    public EmployeeManagement saveEmp(EmployeeManagement employeeManagement) throws Exception {
        EmployeeManagement employeeManagement1 = repository.fetchByEmpId(employeeManagement.getId());
        if(employeeManagement1==null) {
            return repository.save(employeeManagement);
        }else {
            throw new EntityExistsException("You are already signed in");
        }
    }

    public EmployeeManagement update(int id,EmployeeManagement employeeManagement) throws Exception{
        Optional<EmployeeManagement> employeeManagement1 = Optional.ofNullable(repository.findById(id).orElseThrow(()->
        new Exception("Employee Not found with this id")));
        return repository.save(employeeManagement);
    }

    public List<EmployeeManagement> getAllEmp(){
        return repository.findAll();
    }

    public Optional<EmployeeManagement> getAllById(int id){
        return repository.findById(id);
    }

    public void deleteEmp(int id){
        repository.deleteById(id);
    }

}
