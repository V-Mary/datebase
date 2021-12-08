package com.martciv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.martciv.models.converter.UserConverter;
import com.martciv.models.domain.User;
import com.martciv.models.dto.UserDto;
import com.martciv.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getuserList() {
        List<UserDto> responseUserDtoList = new ArrayList<>();
        for (User user:  userService.getAll()) {
            responseUserDtoList.add(UserConverter.toDTO( user));
        }
        return new ResponseEntity<>(responseUserDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        try {
            User searchedUser = userService.getById(id);
            return new ResponseEntity<>(UserConverter.toDTO(searchedUser), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> postUser(@RequestBody UserDto userDto) {
        User createdUser = User.builder()
                .name(userDto.getName())
                .build();
        User responseUser = userService.create(createdUser);
        return new ResponseEntity<>(UserConverter.toDTO(responseUser), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDto> putUser(@RequestBody UserDto userDto, @PathVariable Integer id) {
        try {
            User updatedUserValues = User.builder()
                    .name(userDto.getName())
                    .age(userDto.getAge())
                    .ordered_tickets(userDto.getOrdered_tickets())
                    .build();
            userService.updateById(updatedUserValues, id);
            userDto.setId(id);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}