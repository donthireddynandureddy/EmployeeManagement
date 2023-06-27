package com.employee.management.controller;

import com.employee.management.entity.EmployeeManagement;
import com.employee.management.service.EmployeeManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp_management")
public class EmployeeManagementController {

    @Autowired
    private EmployeeManagementService service;

    @PostMapping("/saveEmpManagement")
    public EmployeeManagement saveEmpMan(@Valid @RequestBody EmployeeManagement employeeManagement) throws Exception {
        return service.saveEmp(employeeManagement);
    }

    @PutMapping("/updateEmpManagement/{id}")
    public EmployeeManagement updateEmpManagement(@PathVariable ("id") int id,
                                                  @RequestBody EmployeeManagement employeeManagement) throws Exception {
        return service.update(id,employeeManagement);
    }

    @GetMapping("/getAllEmpMan")
    public List<EmployeeManagement> getAllEmpMan(){
        return service.getAllEmp();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeManagement> getAllEmpManById(@PathVariable("id") int id){
        return service.getAllById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmpManById(@PathVariable("id") int id){
        service.deleteEmp(id);
        return "Deleted Successfully!!";
    }

}
