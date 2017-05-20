package com.example.thiago.alunomapa;

/**
 * Created by thiago on 13/04/17.
 */

public class Diciplinas {


    private String nomeCadeira;
    private String horario;
    private String bloco;
    private int sala;

    public Diciplinas() {


    }

    public Diciplinas(String nome, String horario, String bloco, int sala) {

        this.nomeCadeira = nome;
        this.horario = horario;
        this.bloco = bloco;
        this.sala = sala;
    }


    //================================  GETSETS

    public String toString(){

        return this.getNomeCadeira();
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getNomeCadeira() {
        return nomeCadeira;
    }

    public void setNomeCadeira(String nomeCadeira) {
        this.nomeCadeira = nomeCadeira;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
