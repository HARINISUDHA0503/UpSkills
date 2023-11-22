package com.example.Service;

import java.util.List;

import com.example.StudentModel.Student;

public interface StudentService {
	public List<Student> showAllStudentDetails();

	public Student addStudent(Student StudentDetails);

	public String deleteStudent(long id);
}
