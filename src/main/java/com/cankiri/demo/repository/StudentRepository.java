package com.cankiri.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cankiri.demo.model.Student;

import jakarta.transaction.Transactional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	//BUNLARIN ZATEN İMPLEMENTASYONUNU SPRİNG YAPIYOR. YANİ İÇİNİ(BODY'SİNİ) SPRİNG KENDİSİ DOLDURUYOR.
	
		List<Student> findByName(String name);
		
		Student findByNumber(Integer number);
		
		List<Student> findByNameAndSurname(String name, String surname);
		
		List<Student> findByNameOrSurname(String name, String surname);
		

		List<Student> findByNameIn(List<String> names);
		
		List<Student> findByNameContains(String name);
		
		List<Student> findByNameStartsWith(String name);
		
		
		//JPAREPOSİTORY 'NİN YETERSİZ KALDIĞI DURUMLARDA @QUERY ANATASYONU KULLANILABİLİR
		
		@Query("SELECT s FROM Student s WHERE s.name=:name")
		List<Student> findMyStudents(String name);
		
		
		@Query(value="SELECT * FROM MY_STUDENTS s WHERE s.name=:name", nativeQuery = true)
		List<Student> findMyStudentsNative(String name);
		
		@Transactional
		@Modifying
		@Query("UPDATE Student s SET s.name=:name WHERE s.id=:id")
		int updateFirstNameById(String name, Long id);
		

	}


