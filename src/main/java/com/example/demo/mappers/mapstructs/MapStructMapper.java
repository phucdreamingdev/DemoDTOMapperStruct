package com.example.demo.mappers.mapstructs;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import com.example.demo.payload.dto.AuthorAllDto;
import com.example.demo.payload.dto.AuthorDto;
import com.example.demo.payload.dto.BookDto;
import com.example.demo.payload.dto.BookSlimDto;
import com.example.demo.payload.dto.UserGetDto;
import com.example.demo.payload.dto.UserPostDto;
import com.example.demo.payload.entities.Author;
import com.example.demo.payload.entities.Book;
import com.example.demo.payload.entities.User;

@Mapper(componentModel = "spring")

public interface MapStructMapper {
	BookSlimDto bookToBookSlimDto(Book book);

	BookDto bookToBookDto(Book book);

	AuthorDto authorToAuthorDto(Author author);

	AuthorAllDto authorToAuthorAllDto(Author author);

	List<AuthorAllDto> authorsToAuthorAllDtos(List<Author> authors);

	UserGetDto userToUserGetDto(User user);

	User userPostDtoToUser(UserPostDto userPostDto);
}
