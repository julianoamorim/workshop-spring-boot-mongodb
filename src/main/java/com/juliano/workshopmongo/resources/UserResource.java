package com.juliano.workshopmongo.resources;


import com.juliano.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping( method=RequestMethod.GET)//indica que o metodo sera retornado no acesso /users
    public ResponseEntity<List<User>> buscarTodos(){
        User maria = new User("1", "Maria Silva", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list); //ResponseEntity: retorna o objeto como resposta HTTP apropriada p/ web
    }
}
