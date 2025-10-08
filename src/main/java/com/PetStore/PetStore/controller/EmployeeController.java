package com.PetStore.PetStore.controller;

import com.PetStore.PetStore.model.Employee;
import com.PetStore.PetStore.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees") public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("/postEmployee") public Employee postEmployee(@RequestBody Employee em){

        employeeRepository.save(em);
        return em;
    }

    @GetMapping("/employee/{id}") public ResponseEntity<Employee>
    getEmployeeById(@PathVariable long id){
        Optional<Employee> employee= employeeRepository.findById(id);
        return ResponseEntity.ok(employee.orElse(null));
    }

    @PutMapping("/updateEmployee/{id}") public ResponseEntity<Employee>
    updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        System.out.println("Inside update");
        Employee employee= employeeRepository.findById(id).orElse(null) ;

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/deleteEmployee/{id}") public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
        employeeRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted", Boolean.TRUE); return ResponseEntity.ok(response);

    }

}
