package com.juliano.workshopmongo.repository;

import com.juliano.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //Repository Mongo gerencia a classe User com id tipo String

}
