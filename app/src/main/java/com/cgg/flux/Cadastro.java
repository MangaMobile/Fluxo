package com.cgg.flux;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Gio on 15/11/2015.
 */
@DynamoDBTable(tableName = "Cadastro")
public class Cadastro {
    private String nome;
    private String email;
    private String senha;
    private String id;

    @DynamoDBIndexRangeKey(attributeName = "Nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @DynamoDBIndexRangeKey(attributeName = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBIndexRangeKey(attributeName = "Senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @DynamoDBHashKey(attributeName = "ID")
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }
}
