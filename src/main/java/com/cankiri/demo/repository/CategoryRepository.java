package com.cankiri.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cankiri.demo.model.Category;

                                                                  
@Repository                                                          //ID
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
    List<Category> findByName(String name);  //CATEGORY'DEKİ NAME ALANI
	
	List<Category> findByNameContains(String name); //NAME'İN İÇİNDE GEÇENLERİ BUL


}
