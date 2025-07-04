package com.library.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            BookService service = context.getBean("bookService", BookService.class);
            System.out.println("RESULT: " + service.getBookDetails("LIB-101"));
        } finally {
            if (context != null) {
                context.close();
            }
        }
    }
}