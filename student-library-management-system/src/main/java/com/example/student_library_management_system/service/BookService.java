package com.example.student_library_management_system.service;

import com.example.student_library_management_system.converter.BookConverter;
import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.model.Book;
import com.example.student_library_management_system.model.Card;
import com.example.student_library_management_system.repository.AuthorRepository;
import com.example.student_library_management_system.repository.BookRepository;
import com.example.student_library_management_system.repository.CardRepository;
import com.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CardRepository cardRepository;

    public String addBook(BookRequestDto bookRequestDto){
        try{
            Book book = BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

            // Using author id fetch the complete object of author from Author repository
            Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
            if(author != null) book.setAuthor(author);
            else book.setAuthor(null);

            // Using card id fetch the complete object of card from Card repository
            Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
            if(card != null) book.setCard(card);
            else book.setCard(null);

            bookRepository.save(book);

            return "Book saved successfully!";
        } catch (Exception e) {
            return "Something went wrong! " + e.getMessage();
        }
    }
}
