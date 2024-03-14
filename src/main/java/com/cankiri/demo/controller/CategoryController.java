package com.cankiri.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cankiri.demo.model.Category;
import com.cankiri.demo.repository.CategoryRepository;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository1;
	
	
	@RequestMapping("/list")  //şeklinde yazarak veriler JSON formatında ekranda yazar 
	public List<Category> getCategories(){
		return categoryRepository1.findAll() ; //BÜTÜN KATEGORİLERİ GETİR FONKSİYONU
		
	}
	//ÖN YÜZ SERVİSİ İÇİN : REQUESTMAPPİNG                      POST UYGULAMASI
	@RequestMapping(value = "/create" , method = RequestMethod.POST)
	public Category createCategory(@RequestBody  Category category1) { //@REQESTBODY : GELEN JSON VERİDEN MODEL DÖNÜŞÜMÜNÜ YAPIYOR
		return categoryRepository1.save(category1);
		
	}
	@RequestMapping(value = "/update" , method = RequestMethod.POST)
	public Category update(@RequestBody  Category category1) {
		return categoryRepository1.save(category1);
		
	}

}



