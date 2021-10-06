package com.juliano.workshopmongo.repository;

import com.juliano.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //Repository Mongo gerencia a classe User com id tipo String

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") //query manual do MongoDB, ver documentacao
    List<Post> buscarTitulo(String text);

    List<Post> findByTitleContainingIgnoreCase(String text); //Query Method MongoDB, metodo de pesquisa automatico, ver documentacao
}
