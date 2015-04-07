package com.evo.citicargasmobile.Entity;

import java.io.Serializable;

/**
 * Created by Daniel on 06/04/2015.
 */
public class Veiculo implements Serializable {

    public long id;
    public long idTrasportador;
    public String placa;
    public String renavam;
    public String marca;
    public String anoFabricacao;
    public String propriedade;

    public Veiculo(long id, long idTrasportador, String placa, String renavam, String marca, String anoFabricacao, String propriedade) {
        this.id = id;
        this.idTrasportador = idTrasportador;
        this.placa = placa;
        this.renavam = renavam;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.propriedade = propriedade;
    }

    public Veiculo(long idTrasportador, String placa, String renavam, String marca, String anoFabricacao, String propriedade) {
        this.idTrasportador = idTrasportador;
        this.placa = placa;
        this.renavam = renavam;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.propriedade = propriedade;
    }
}
