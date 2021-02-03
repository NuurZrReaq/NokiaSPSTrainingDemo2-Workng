package project.nokiaspstraining.demo.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.nokiaspstraining.demo.rest.repositories.UserRepo;
import project.nokiaspstraining.demo.rest.repositories.UserRepoAerospike;
import project.nokiaspstraining.demo.wsdl.User;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private UserRepoAerospike userRepoAerospike;




    @RequestMapping("/{name}")
    @ResponseBody
    public User getUser (@PathVariable String name) {
        User  user = userRepository.findUser(name);
        return user;


    }


    @RequestMapping(method = RequestMethod.POST,value = "/addUser")
    public void addUser(@RequestBody User user){
        if(user != null)
            userRepoAerospike.save(user);

    }



}