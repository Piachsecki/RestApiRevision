package com.example.restapirevision.controller;


import com.example.restapirevision.domain.Employee;
import com.example.restapirevision.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.restapirevision.controller.EmployeeController.EMPLOYEE_ENDPOINT;

@RestController
@RequestMapping(EMPLOYEE_ENDPOINT)
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private final EmployeeServiceImpl employeeService;
    public static final String EMPLOYEE_ENDPOINT = "/employees";
    public static final String EMPLOYEE_ID = "{employeeId}";


    @GetMapping(value = EMPLOYEE_ID)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId){
        Employee employeeById = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeById);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee addedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedEmployee);
    }


}
