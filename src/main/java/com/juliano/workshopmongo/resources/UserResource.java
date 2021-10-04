package com.juliano.workshopmongo.resources;


import com.juliano.workshopmongo.domain.User;
import com.juliano.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping( method=RequestMethod.GET)//indica que o metodo sera retornado no acesso /users
    public ResponseEntity<List<User>> buscarTodos(){
        List<User> list = service.buscarTodos();
        return ResponseEntity.ok().body(list); //ResponseEntity: retorna o objeto como resposta HTTP apropriada p/ web
    }
}
