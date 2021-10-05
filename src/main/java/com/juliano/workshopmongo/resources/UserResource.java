package com.juliano.workshopmongo.resources;


import com.juliano.workshopmongo.domain.User;
import com.juliano.workshopmongo.dto.UserDTO;
import com.juliano.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping( method=RequestMethod.GET)//indica que o metodo sera retornado no acesso /users
    public ResponseEntity<List<UserDTO>> buscarTodos(){
        List<User> list = service.buscarTodos();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //corverte os objetos User p UserDTO
        return ResponseEntity.ok().body(listDto); //ResponseEntity: retorna o objeto como resposta HTTP apropriada p/ web
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)//indica que o metodo sera retornado no acesso /users
    public ResponseEntity<UserDTO> buscarId(@PathVariable String id){ //id sera passado pela URL
        User obj = service.buscarId(id);
        return ResponseEntity.ok().body(new UserDTO(obj)); //ResponseEntity: retorna o objeto como resposta HTTP apropriada p/ web
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> inserir(@RequestBody UserDTO objDto){
        User obj = service.fromDTO(objDto); //converte dto p user
        obj = service.inserir(obj); //metodo p inserir o usuario
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //codigo apresentado do nada (?)
        return ResponseEntity.created(uri).build(); //Retorna o cod 201 e cabecalho e localizacao do recurso
    }
}
