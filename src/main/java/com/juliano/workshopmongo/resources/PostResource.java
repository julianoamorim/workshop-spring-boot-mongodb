package com.juliano.workshopmongo.resources;


import com.juliano.workshopmongo.domain.Post;
import com.juliano.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method=RequestMethod.GET)//indica que o metodo sera retornado no acesso /users
    public ResponseEntity<Post> buscarId(@PathVariable String id){ //id sera passado pela URL
        Post obj = service.buscarId(id);
        return ResponseEntity.ok().body(obj); //ResponseEntity: retorna o objeto como resposta HTTP apropriada p/ web
    }

}
