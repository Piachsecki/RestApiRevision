package com.example.restapirevision.service;

import com.example.restapirevision.domain.Employee;
import com.example.restapirevision.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl {
    @Autowired
    private final EmployeeRepo employeeRepo;

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElseThrow();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }


}
