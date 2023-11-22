package com.example.demo.controller;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.Service.StudentServiceImpl;
import com.example.StudentModel.Student;
import com.example.studentController.StudentController;

import java.util.ArrayList;

import java.util.List;
 
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
 
public class StudentControllerTest {
 
    private MockMvc mockMvc;
 
    @Mock

    private StudentServiceImpl studentService;
 
    @InjectMocks

    private StudentController studentController;
 
    @BeforeEach

    public void setup() {

        MockitoAnnotations.openMocks(this);

        this.mockMvc = standaloneSetup(studentController).build();

    }
 
    @Test

    public void testShowAllStudentDetails() throws Exception {

        // Mock data

        List<Student> mockStudents = new ArrayList<>();

        mockStudents.add(new Student(1L, "Alice",20,2000));

        mockStudents.add(new Student(2L, "Bob",12,25000));
 
        // Mock service method

        when(studentService.showAllStudentDetails()).thenReturn(mockStudents);
 
        // Perform GET request and verify response

        mockMvc.perform(MockMvcRequestBuilders.get("/student/all"))

                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Alice"))

                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Bob"))

                .andDo(print());

    }
 
    @Test

    public void testAddStudent() throws Exception {

        // Mock data

        Student newStudent = new Student(3L, "Charlie",22,5000);
 
        // Mock service method

        when(studentService.addStudent(any(Student.class))).thenReturn(newStudent);
 
        // Perform POST request and verify response

        mockMvc.perform(MockMvcRequestBuilders.post("/student/add")

                .content("{ \"id\": 3, \"name\": \"Charlie\" }")

                .contentType(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Charlie"))

                .andDo(print());

    }
 
    @Test

    public void testDeleteStudent() throws Exception {

        long studentId = 4;
 
        // Perform DELETE request and verify response

        mockMvc.perform(MockMvcRequestBuilders.delete("/student/delete/{id}", studentId))

                .andExpect(MockMvcResultMatchers.status().isOk())

                .andExpect(MockMvcResultMatchers.content().string("Deleted Successfully"))

                .andDo(print());

    }

}