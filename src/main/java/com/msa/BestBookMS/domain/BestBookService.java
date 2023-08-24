package com.msa.BestBookMS.domain;

import com.msa.BestBookMS.domain.model.BestBook;
import com.msa.BestBookMS.domain.model.vo.Item;
import com.msa.BestBookMS.persistence.BestBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BestBookService {
    private final BestBookRepository bookRepository;

    public List<BestBook> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BestBook> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public BestBook createBook(BestBook book) {
        return bookRepository.save(book);
    }

    public BestBook updateBook(String id, BestBook book) {
        Optional<BestBook> existingBookOptional = bookRepository.findById(id);
        if (existingBookOptional.isPresent()) {
            BestBook existingBook = existingBookOptional.get();
            existingBook.setItem(book.getItem());
            existingBook.setRentCount(book.getRentCount());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    public boolean deleteBook(String id) {
        Optional<BestBook> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
            return true;
        }
        return false;
    }

    public void dealBestBook(Item item){
        BestBook bestBookByItem = bookRepository.findBestBookByItem(item);
        if (bestBookByItem != null){
            bestBookByItem.increseBestBookCount();
        } else {
           bestBookByItem =  createBook(BestBook.registerBestBook(item));
        }
        bookRepository.save(bestBookByItem);
    }
}
