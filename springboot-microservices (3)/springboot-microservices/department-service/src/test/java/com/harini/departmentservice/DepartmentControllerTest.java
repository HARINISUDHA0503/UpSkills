package com.harini.departmentservice;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.harini.departmentservice.controller.DepartmentController;
import com.harini.departmentservice.dto.DepartmentDto;
import com.harini.departmentservice.service.DepartmentService;
 
public class DepartmentControllerTest {
 
    @Mock
    private DepartmentService departmentService;
 
    @InjectMocks
    private DepartmentController departmentController;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    @Test
    void testSaveDepartment() {
        // Given
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode("IT");
        departmentDto.setDepartmentName("Information Technology");
 
        when(departmentService.saveDepartment(any())).thenReturn(departmentDto);
 
        // When
        ResponseEntity<DepartmentDto> responseEntity = departmentController.saveDepartment(departmentDto);
 
        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(departmentDto, responseEntity.getBody());
    }
 
    @Test
    void testGetDepartment() {
        // Given
        String departmentCode = "IT";
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentCode(departmentCode);
        departmentDto.setDepartmentName("Information Technology");
 
        when(departmentService.getDepartmentByCode(departmentCode)).thenReturn(departmentDto);
 
        // When
        ResponseEntity<DepartmentDto> responseEntity = departmentController.getDepartment(departmentCode);
 
        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(departmentDto, responseEntity.getBody());
    }
}