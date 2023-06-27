package com.employee.management.repository;

import com.employee.management.entity.EmployeeManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeManagementRepository extends JpaRepository<EmployeeManagement,Integer> {

    @Query("select i from EmployeeManagement i where i.id=:id")
    EmployeeManagement fetchByEmpId(int id);

}
