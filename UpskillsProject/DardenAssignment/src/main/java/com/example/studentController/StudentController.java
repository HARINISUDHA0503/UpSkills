package com.example.studentController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.StudentServiceImpl;
import com.example.StudentModel.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	Logger log= LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentServiceImpl service;
	
	@GetMapping("/all")
	public List<Student> showAllStudentDetails(){
		List<Student> studentDetails = service.showAllStudentDetails();
		log.info("All student details listed");
		return(studentDetails);
	}
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		Student stu = service.addStudent(student);
		log.info("Student added successfully");
		return (stu);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id")long id) {
		service.deleteStudent(id);
		log.info("Student deleted successfully"+id);
		return ("Deleted Successfully");
	}
}
