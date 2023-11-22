package com.example.Repostiory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentModel.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long>{

	
}
