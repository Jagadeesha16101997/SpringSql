package com.spring.springMysql.Controller;

import com.spring.springMysql.Repository.EmployeeRepository;
import com.spring.springMysql.model.Employee;
import com.spring.springMysql.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/welcome")
    public String welcome()
    {
        return "Successfully connected to cloud sql";
    }


    public ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object objResponse)
    {
        Map<String,Object> mapp = new HashMap<String,Object>();
        mapp.put("message", message);
        mapp.put("status",status.value());
        mapp.put("data",objResponse);

        return new ResponseEntity<Object>(mapp,status);

    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody EmployeeDTO employeeDTO)
    {
        Employee emp = new Employee();
        emp.setName(employeeDTO.getName());
        emp.setSalary(employeeDTO.getSalary());
        emp = employeeRepository.save(emp);
        return generateResponse("Successfull updated",HttpStatus.OK,emp);
    }

    @RequestMapping("/getitems")
    public ResponseEntity<Object> getItems()
    {
        List<Employee> items = employeeRepository.findAll();
        return generateResponse("Successfull retrieved",HttpStatus.OK,items);
    }








}
