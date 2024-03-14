package com.cankiri.demo.bootstrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.cankiri.demo.model.Category;
import com.cankiri.demo.repository.CategoryRepository;



public class BootstrapData  implements CommandLineRunner {

	//UYGULAMA AYAĞA KALKTIĞINDA BİRTAKIM VERİLERLE AYAĞA KALKSIN İSTİYORUZ O YÜZDEN run metodu
	
    //AUTOWİRED, CATEGORYREPOSİTORY İNTERFACİNE KARŞILIK GELEN NESNENİN İMPL DİREK KOYMUŞ OLUYOR. YANİ ASLINDA NEW'LEME YAPIYOR. YANİ;
		  // private CategoryDao categoryDao1 = new CategoryDaoImpl();
		
    @Autowired
	private CategoryRepository categoryRepository1;
    
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Category cat1 = new Category();
		cat1.setName("Bilgisayar");
		
		Category cat2 = new Category();
		cat1.setName("Sanat");
		
		
		categoryRepository1.save(cat1);
		categoryRepository1.save(cat2);
		
		List<Category> findByNameContains = categoryRepository1.findByNameContains("gisa");
		for(Category cat : findByNameContains ) {
			System.out.println(cat.getName());  //İÇİNDE GİSA GEÇEN NAME 'İ GETİR,YAZDIRDIK. SONUÇ: Bilgisayar
		}
		
	}
	
	

		
	}


