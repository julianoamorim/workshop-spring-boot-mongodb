package com.juliano.workshopmongo.services;

import com.juliano.workshopmongo.domain.User;
import com.juliano.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Servico injetavel em outras classes
public class UserService {
    @Autowired //instancia automaticamente
    private UserRepository repo; //injecao de dependencia automatica

    public List<User> buscarTodos(){
        return repo.findAll(); //Metodo do MongoRepository
    }
}
