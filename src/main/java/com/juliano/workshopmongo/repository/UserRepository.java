package com.juliano.workshopmongo.repository;

import com.juliano.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> { //Repository Mongo gerencia a classe User com id tipo String

}
