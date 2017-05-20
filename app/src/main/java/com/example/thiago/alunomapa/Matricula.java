package com.example.thiago.alunomapa;

/**
 * Created by toliveira on 22/04/17.
 */

public class Matricula {
    private String matricula;
    private String senha;
    private String curso;


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {

        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
