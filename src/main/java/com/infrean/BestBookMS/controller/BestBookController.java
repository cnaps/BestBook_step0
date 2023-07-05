package com.infrean.BestBookMS.controller;

import com.infrean.BestBookMS.domain.model.BestBook;
import com.infrean.BestBookMS.service.BestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BestBookController {

    private final BestBookService bookService;

    @GetMapping
    public ResponseEntity<List<BestBook>> getAllBooks() {
        List<BestBook> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BestBook> getBookById(@PathVariable("id") String id) {
        Optional<BestBook> bookOptional = bookService.getBookById(id);
        return bookOptional.map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BestBook> createBook(@RequestBody BestBook book) {
        BestBook createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BestBook> updateBook(@PathVariable("id") String id, @RequestBody BestBook book) {
        BestBook updatedBook = bookService.updateBook(id, book);
        return updatedBook != null
                ? new ResponseEntity<>(updatedBook, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
