package com.restapi.apidemo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.apidemo.entities.BookEntities;
import com.restapi.apidemo.services.services;



@RestController
public class BookController {
   
    @Autowired
    private services services;

    // GET MAPPING 
    //GET ALL BOOKS
    @GetMapping("/books")
    public ResponseEntity<List<BookEntities>>getBookEntities(){
        List<BookEntities>list = services.getAllBookEntities();
        if (list.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
        return ResponseEntity.of(Optional.of(list));
    }

    // GET MAPPING 
    // GET SINGLE BOOK BY ID 
    @GetMapping("/books/{id}")
    public ResponseEntity<BookEntities>getBookEntitiy(@PathVariable("id")int id){
        BookEntities bookEntities = services.getBookBookEntitiesById(id);
        if (bookEntities == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.of(Optional.of(bookEntities));

    }
    

    //POST MAPPING 
    @PostMapping("/books")
    public ResponseEntity<BookEntities> addBookEntities(@RequestBody BookEntities bookEntities){
    BookEntities bookEntities2 = services.addBookEntities(bookEntities);
    if (bookEntities2 == null) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
        return ResponseEntity.of(Optional.of(bookEntities));
    
    }

    //DELETE MAPPING 
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable int bookId) {
        services.deleteBook(bookId);
}

//UPDATE MAPPING 
@PutMapping("/books/{bookId}")
public BookEntities updateBook(
        @RequestBody BookEntities bookEntities,
        @PathVariable("bookId") int bookId) {

    return this.services.updateBook(bookEntities, bookId);
}


 }
    
    

