package com.juliano.workshopmongo.resources;


import com.juliano.workshopmongo.domain.Post;
import com.juliano.workshopmongo.resources.util.URL;
import com.juliano.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/titlesearch", method=RequestMethod.GET)//consulta ao Banco de Dados pela URL
    public ResponseEntity<List<Post>> buscarTitulo(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodedParam(text); //decodifica o texto
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list); //ResponseEntity: retorna o objeto como resposta HTTP apropriada p/ web
    }

}
