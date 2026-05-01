package com.restapi.apidemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.restapi.apidemo.entities.BookEntities;


@Component
public class services {
    private static List<BookEntities> list = new ArrayList<>();

    static{
          list.add(new BookEntities(12, "Aryan", "Java is very good subjetct "));
          list.add(new BookEntities(133, "Ram", "My favourite language is java "));
          list.add(new BookEntities(222, "sam", "Spring boot is best Framework "));
    }
          //get all books
          public List<BookEntities>getAllBookEntities(){
            return list;
          }

          //get Single book by id
          public BookEntities getBookBookEntitiesById(int id) {
        
            return list.stream()
            .filter(e -> e.getId() == id)
            .findFirst()
            .orElse(null);
          
}

          //POST - ADD BOOK
          public BookEntities addBookEntities(BookEntities bookEntities) {
          list.add(bookEntities);
          return bookEntities;
}           

          //DELETE - TO REMOVE BOOK 
          public void deleteBook(int bookId){
            list = list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
                    }

          //PUT - TO UPDATE BOOK 
          public BookEntities updateBook(BookEntities book, int bookId) {
           list = list.stream().map(b -> {
           if (b.getId() == bookId) {
            b.setName(book.getName());
            b.setAuthor(book.getAuthor());
            }
             return b;
            }).collect(Collectors.toList());

             return book;
}
 
          }
    

    
    
