package org.adaschool.api.Controller;

import  java.util.List;
import  java.util.ArrayList;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private List<User> userList;

    public UserController(){
        this.userList = new ArrayList<>();

    }

    //Metodo para obtener todos los usuarios Create-->Get
    @GetMapping
    public List<User> getAllUser(){
        return this.userList;
    }

    //Metodo para agregar un usuario Read->Post
    @PostMapping
    public void addUser(@RequestBody User newUser){
        this.userList.add(newUser);

    }


    //Metodo para actualizar un usuario existente Update->Put
    @PutMapping("/{userId}")
    public void updateUser(@PathVariable String userId, @RequestBody User updateUser){
        for (int i = 0; i<this.userList.size(); i++){
            if (this.userList.get(i).getId().equals(userId)){
                this.userList.set(i,updateUser);
                break;
            }
        }
    }

    //Metodo para eliminar un usuario existente DELETE->DELETE
    @DeleteMapping("/{userId}")
    public void deletUser(@PathVariable String UserId){
        this.userList.removeIf(user -> user.getId().equals(userId));
    }

}
