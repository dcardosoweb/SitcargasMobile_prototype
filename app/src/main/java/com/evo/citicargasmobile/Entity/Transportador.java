package com.evo.citicargasmobile.Entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Daniel on 23/03/2015.
 */
public class Transportador implements Serializable{

    public long id;
    public String nome;
    public String rntrc;
    public String cpfCnpj;
    public String tipoTransportador;
    public String dataValidade;
    public String dataRecadastramento;
    public String dataEmissao;
    public String situacaoRntrc;
    public String sexo;
    public String uf;
    public String numeroIdentidade;
    public String orgaoIdentidade;
    public String cnh;
    public String categoriaCnh;
    public String dataNascimento;

    public Transportador(){
    }

    public Transportador(long id, String nome, String rntrc, String cpfCnpj, String tipoTransportador, String dataValidade, String dataRecadastramento,
                         String dataEmissao, String situacaoRntrc, String sexo, String uf, String numeroIdentidade, String orgaoIdentidade,
                         String cnh, String categoriaCnh, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.rntrc = rntrc;
        this.cpfCnpj = cpfCnpj;
        this.tipoTransportador = tipoTransportador;
        this.dataValidade = dataValidade;
        this.dataRecadastramento = dataRecadastramento;
        this.dataEmissao = dataEmissao;
        this.situacaoRntrc = situacaoRntrc;
        this.sexo = sexo;
        this.uf = uf;
        this.numeroIdentidade = numeroIdentidade;
        this.orgaoIdentidade = orgaoIdentidade;
        this.cnh = cnh;
        this.categoriaCnh = categoriaCnh;
        this.dataNascimento = dataNascimento;
    }

    public Transportador( String nome, String rntrc, String cpfCnpj, String tipoTransportador, String dataValidade, String dataRecadastramento,
                          String dataEmissao, String situacaoRntrc, String sexo, String uf, String numeroIdentidade, String orgaoIdentidade,
                         String cnh, String categoriaCnh, String dataNascimento) {
        this.nome = nome;
        this.rntrc = rntrc;
        this.cpfCnpj = cpfCnpj;
        this.tipoTransportador = tipoTransportador;
        this.dataValidade = dataValidade;
        this.dataRecadastramento = dataRecadastramento;
        this.dataEmissao = dataEmissao;
        this.situacaoRntrc = situacaoRntrc;
        this.sexo = sexo;
        this.uf = uf;
        this.numeroIdentidade = numeroIdentidade;
        this.orgaoIdentidade = orgaoIdentidade;
        this.cnh = cnh;
        this.categoriaCnh = categoriaCnh;
        this.dataNascimento = dataNascimento;
    }

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

    public Transportador(long id, String nome, String rntrc, String cpfCnpj, String tipoTransportador, String uf, String situacaoRntrc) {
        this.id = id;
        this.nome = nome;
        this.rntrc = rntrc;
        this.cpfCnpj = cpfCnpj;
        this.tipoTransportador = tipoTransportador;
        this.uf = uf;
        this.situacaoRntrc = situacaoRntrc;
    }

    @Override
    public String toString(){
        return nome;
    }
}
