package com.cankiri.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BlogPost {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne                       //birden fazla blogpost bir kategoriye aittir diyoruz
	@JoinColumn(name = "category_id")  //foreign key
	private Category category1; //BAşka bir tablonun nesnesi

	private String title;
	@Column(columnDefinition = "TEXT")   //DAHA GENİŞ BİR ALAN İÇİN
	private String content;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory1() {
		return category1;
	}

	public void setCategory1(Category category1) {
		this.category1 = category1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}



