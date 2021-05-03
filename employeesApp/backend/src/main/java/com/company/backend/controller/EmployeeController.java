package com.company.backend.controller;

import com.company.backend.dto.EmployeeDTO;
import com.company.backend.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.company.backend.exception.ResourceNotFoundException;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/employee")
public class EmployeeController{
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController (final EmployeeService employeeService){this.employeeService = employeeService;}

    @RequestMapping("/all")
    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
    final List<EmployeeDTO> employees = employeeService.getEmployess() .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));;
        LOGGER.info("Employees Size: {}",employees.size());
        return new ResponseEntity(employees,OK);


    @RequestMapping("/{id}")
    @GetMapping(produces = {"application/json"})
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") final String id){
        final EmployeeDTO employee = employeeService.getEmployee(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));;
        LOGGER.info("EmployeeDTO: {}",employeeDTO.getID());
        return new ResponseEntity(employee,OK);
    }

    @RequestMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(produces = {"application/json"})
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        LOGGER.info("EmployeeDTO: {}",employeeDTO.getID());
        employeeService.updateEmployee(employeeDTO).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));;
        return new ResponseEntity("Success",OK);
    }

    @RequestMapping("/")
    @PostMapping(produces = {"application/json"})
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @RequestMapping("/employees/{id}")
    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
