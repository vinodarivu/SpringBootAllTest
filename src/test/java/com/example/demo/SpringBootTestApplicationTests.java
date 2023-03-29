package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.H2DBDataController;
import com.example.demo.entity.BookEntity;
import com.example.demo.repo.BookEntityRepo;

@SpringBootTest
class SpringBootTestApplicationTests {

	@InjectMocks
	H2DBDataController h2DBDataController;

	@Mock
	BookEntityRepo bookEntityRepo;
	
	

	@Test
	void contextLoads() {
	}

	@Test
	public void controllerTest() {
		System.out.println("****************************************************inside controllerTest");
		ArrayList<BookEntity> al = new ArrayList<>();
		BookEntity bookEntity = new BookEntity();
		bookEntity.setAge(10);
		al.add(bookEntity);
		when(bookEntityRepo.findByAge(Mockito.anyInt())).thenReturn(al);
		ArrayList<BookEntity> bookList = (ArrayList<BookEntity>) h2DBDataController.getBookByAge(10);
		//System.out.println("BookList****************************************************BookList"+bookList);
		assertEquals(al.get(0).getAge(), bookList.get(0).getAge());
	}

}
