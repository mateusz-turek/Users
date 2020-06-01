package com.mat.users.Controller;

import com.mat.users.Model.User;
import com.mat.users.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/home", produces = "application/json")
@CrossOrigin("*")
@Slf4j
public class Controller {

   private UserRepository userRepository;

    @Autowired
    public Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        Optional<User> userPresence = userRepository.findById(id);
        log.info("request for id " + id.toString());
        if (userPresence.isPresent()){
            log.info("found id " + id.toString());
            return new ResponseEntity<>(userPresence.get(), HttpStatus.OK);
        }
        log.info("not found id of " + id.toString());
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "/add" , consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public User postUser(@RequestBody User user){
        log.info(user.toString());
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/user/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        log.info("deleted "+id.toString());
        userRepository.deleteById(id);
    }

    /*
    // you can also use imports, for example:
// import java.util.*;
import java.util.Arrays;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {


        ArrayManager.setInputIntegers(A);
        ArrayManager.setIntegers(A);
        ArrayManager.setUnpairedDigit();


        return ArrayManager.unpairedDigit;
    }


    public static class ArrayManager {

        private static Integer unpairedDigit;

        private static Integer [] inputIntegers;

        private static Integer [] integers;

        private static boolean flag;

        private static void setUnpairedDigit (){
            if (1==integers.length){
                unpairedDigit = integers[0];
            }else{

            int index = 0;



                for(Integer j: integers){


                    for (int i = 0; i <integers.length ; i++) {

                        if (i!=index){

                            if(integers[i]==j){

                              break;
                            } else {
                                unpairedDigit = j;
                                break;
                            }
                        }

                    }
                    index++;

                    if (unpairedDigit !=null){
                        break;
                    }else {

                    }
                }

            }
        }



         private static void setInputIntegers (int[] array){

            inputIntegers = new Integer[array.length];

            for (int i = 0; i <array.length ; i++) {
                inputIntegers[i] = array[i];
            }

        }

        private static void setIntegers (int[] array){

            integers = new Integer[array.length];

            for (int i = 0; i <array.length ; i++) {
                integers[i] = array[i];
            }
            Arrays.sort(integers);

        }



        private static void setFlag(){



        }

    }
}
     */

}
