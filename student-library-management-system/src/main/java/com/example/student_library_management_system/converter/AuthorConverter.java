package com.example.student_library_management_system.converter;

import com.example.student_library_management_system.model.Author;
import com.example.student_library_management_system.requestdto.AuthorRequestDto;

public class AuthorConverter {

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();

        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(authorRequestDto.getGender());
        author.setCountry(authorRequestDto.getCountry());
        author.setRating(authorRequestDto.getRating());

        return author;
    }
}
