package com.juliano.workshopmongo.dto;

import com.juliano.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable { //Classe que filtra os dados do Usuario a serem passados para o frontend
    private static final long serialVersionUID = 1L; //permite q o objeto seja convertido em byte e trafegado em rede

    private String id;
    private String nome;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
