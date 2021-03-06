package com.juliano.workshopmongo.services;

import com.juliano.workshopmongo.domain.User;
import com.juliano.workshopmongo.dto.UserDTO;
import com.juliano.workshopmongo.repository.UserRepository;
import com.juliano.workshopmongo.services.exception.ObjetoNaoEncontradoExcecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Servico injetavel em outras classes
public class UserService {

    @Autowired //instancia automaticamente
    private UserRepository repo; //injecao de dependencia automatica / acesso ao banco de dados

    public List<User> buscarTodos(){
        return repo.findAll(); //Metodo do MongoRepository
    }

    public User buscarId(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjetoNaoEncontradoExcecao("Objeto não encontrado"));
    }

    public User inserir(User obj){
        return repo.insert(obj);
    }

    public void deletar(String id){
        buscarId(id); //caso nao encontre lanca a excecao
        repo.deleteById(id);
    }

    public User atualizar(User obj){
        User newObj = buscarId(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    //tem acesso ao banco de dados direto na classe
    public  User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getNome(), objDto.getEmail());
    }
}
