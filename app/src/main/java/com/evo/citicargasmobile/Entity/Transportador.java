package com.evo.citicargasmobile.Entity;

import java.io.Serializable;

/**
 * Created by Daniel on 23/03/2015.
 */
public class Transportador implements Serializable{

    public long id;
    public String nome;
    public String rntrc;
    public String cpfCnpj;

    public Transportador(String cpfCnpj, String rntrc, String nome, long id) {
        this.cpfCnpj = cpfCnpj;
        this.rntrc = rntrc;
        this.nome = nome;
        this.id = id;
    }

    public Transportador(String cpfCnpj, String rntrc, String nome) {
        this.cpfCnpj = cpfCnpj;
        this.rntrc = rntrc;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return nome;
    }
}
