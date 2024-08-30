package com.webServerProject.SpringProject1.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webServerProject.SpringProject1.Services.Course;

@RestController
public class CourseController {

	// http://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return Arrays.asList(new Course(1, "Learn Java Full Stack Course", "UniqTechnologies"),
				new Course(2, "Learn Javascript Full Stack Course", "UniqTechnologies"),
				new Course(3, "Learn Machine Learning", "UniqTechnologies"));
	}

	// http://localhost:8080/courses/1
	@GetMapping("/courses/1")
	public Course getCourseDetails() {
		return new Course(1, "Learn Java Full Stack Course", "UniqTechnologies");
	}

	//http://localhost:8080/course/
	@GetMapping("course/{id}")
	public ResponseEntity<String> getUserById(@PathVariable("id") Long id) {
		return ResponseEntity.ok("User ID: " + id);
	}

	//http://localhost:8080/api?id=1
	@GetMapping("/api")
	public ResponseEntity<String> getUserById_1(@RequestParam("id") Long id) {
		return ResponseEntity.ok("User ID: " + id);
	}

}