package com.harini.employeeservice.service;

import com.harini.employeeservice.dto.APIResponseDto;
import com.harini.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
