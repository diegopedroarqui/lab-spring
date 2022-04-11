package com.udea.empleados.controller;

import com.udea.empleados.model.Employee;
import com.udea.empleados.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Api(value="Employee Management System")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "View a list of available employees", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found ")
    })
    public ResponseEntity<?> findAll() {
        List<Employee> employees = this.employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete an employee by its id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Successfully deleted employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found, or there is no employee with the id provided")
    })
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id) {
        boolean deleted = this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(deleted, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create")
    @ApiOperation(value = "Add a new employee", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found ")
    })
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        employee = this.employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an employee", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully edited employee"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found, or there is no employee with the id provided")
    })
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        employee = this.employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/{id}/updateSalary")
    @ApiOperation(value = "Update an employee salary", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated employee salary"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found, or there is no employee with the id provided")
    })
    public ResponseEntity<?> checkForEmployeeSalaryUpdate(@PathVariable Long id) {
        boolean salaryUpdated = this.employeeService.checkForEmployeeSalaryUpdate(id);
        return new ResponseEntity<>(salaryUpdated, HttpStatus.NO_CONTENT);
    }
}
