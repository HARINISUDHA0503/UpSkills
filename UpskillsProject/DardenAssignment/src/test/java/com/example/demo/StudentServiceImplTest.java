package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
 
import java.util.Arrays;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Repostiory.StudentRepository;
import com.example.Service.StudentServiceImpl;
import com.example.StudentModel.Student;
 

 
@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
 
    @Mock
    private StudentRepository studentRepository;
 
    @InjectMocks
    private StudentServiceImpl studentService;
 
    @Test
    void testShowAllStudentDetails() {
        // Arrange
        List<Student> students = Arrays.asList(
                new Student(1L, "John", 25, 20000),
                new Student(2L, "Jane", 22,15000)
                // Add more students as needed
        ); 
 
        when(studentRepository.findAll()).thenReturn(students);
 
        // Act
        List<Student> result = studentService.showAllStudentDetails();
 
        // Assert
        assertEquals(students, result);
    }
 
    @Test
    void testAddStudent() {
        // Arrange
        Student newStudent = new Student();
 
        when(studentRepository.insert(newStudent)).thenReturn(newStudent);
 
        // Act
        Student result = studentService.addStudent(newStudent);
 
        // Assert
        assertEquals(newStudent, result);
    }
 
    @Test
    void testDeleteStudent() {
        // Arrange
        long studentIdToDelete = 1L;
 
        // Act
        String result = studentService.deleteStudent(studentIdToDelete);
 
        // Assert
        assertEquals("Student with the " + studentIdToDelete + "Deleted successfully", result);
    }
}