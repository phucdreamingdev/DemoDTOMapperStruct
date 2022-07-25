package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mappers.mapstructs.MapStructMapper;
import com.example.demo.payload.dto.UserGetDto;
import com.example.demo.payload.dto.UserPostDto;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private MapStructMapper mapStructMapper;
	@Autowired
	private UserRepository userRepository;

	

	@PostMapping()
	public ResponseEntity<Void> create(@Valid @RequestBody UserPostDto userPostDto) {
		userRepository.save(mapStructMapper.userPostDtoToUser(userPostDto));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserGetDto> getById(@PathVariable(value = "id") int id) {
		return new ResponseEntity<>(mapStructMapper.userToUserGetDto(userRepository.findById(id).get()), HttpStatus.OK);
	}

}