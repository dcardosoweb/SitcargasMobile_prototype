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
    public String uf;

    public String contatoCelular;
    public String contatoEmail;
    public String contatoFixo;
    public String contatoFax;
    public String enderecoComercial;
    public String enderecoCorrespondencia;


    public Transportador(){
    }

    public Transportador(long id, String nome, String rntrc, String cpfCnpj, String tipoTransportador, String dataValidade, String dataRecadastramento, String dataEmissao,
                         String situacaoRntrc, String uf, String contatoCelular, String contatoEmail, String contatoFixo, String contatoFax, String enderecoComercial, String enderecoCorrespondencia) {
        this.id = id;
        this.nome = nome;
        this.rntrc = rntrc;
        this.cpfCnpj = cpfCnpj;
        this.tipoTransportador = tipoTransportador;
        this.dataValidade = dataValidade;
        this.dataRecadastramento = dataRecadastramento;
        this.dataEmissao = dataEmissao;
        this.situacaoRntrc = situacaoRntrc;
        this.uf = uf;
        this.contatoCelular = contatoCelular;
        this.contatoEmail = contatoEmail;
        this.contatoFixo = contatoFixo;
        this.contatoFax = contatoFax;
        this.enderecoComercial = enderecoComercial;
        this.enderecoCorrespondencia = enderecoCorrespondencia;
    }

    public Transportador(String nome, String rntrc, String cpfCnpj, String tipoTransportador, String dataValidade, String dataRecadastramento, String dataEmissao,
                         String situacaoRntrc, String uf, String contatoCelular, String contatoEmail, String contatoFixo, String contatoFax, String enderecoComercial, String enderecoCorrespondencia) {
        this.nome = nome;
        this.rntrc = rntrc;
        this.cpfCnpj = cpfCnpj;
        this.tipoTransportador = tipoTransportador;
        this.dataValidade = dataValidade;
        this.dataRecadastramento = dataRecadastramento;
        this.dataEmissao = dataEmissao;
        this.situacaoRntrc = situacaoRntrc;
        this.uf = uf;
        this.contatoCelular = contatoCelular;
        this.contatoEmail = contatoEmail;
        this.contatoFixo = contatoFixo;
        this.contatoFax = contatoFax;
        this.enderecoComercial = enderecoComercial;
        this.enderecoCorrespondencia = enderecoCorrespondencia;
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
