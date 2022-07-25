package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mappers.mapstructs.MapStructMapper;
import com.example.demo.payload.dto.AuthorAllDto;
import com.example.demo.payload.entities.Author;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private MapStructMapper mapStructMapper;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping()
	public ResponseEntity<List<AuthorAllDto>> getAll() {
		return new ResponseEntity<>(mapStructMapper.authorsToAuthorAllDtos(authorRepository.findAll()), HttpStatus.OK);
	}
	

}
