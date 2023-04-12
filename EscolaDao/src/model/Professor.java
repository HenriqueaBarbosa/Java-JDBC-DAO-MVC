package model;

import java.util.Objects;

public class Professor extends Turma {
    private Long id;
    private String nome;
    private String formacao;

    public Professor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor professor)) return false;
        return Objects.equals(getId(), professor.getId()) && Objects.equals(getNome(), professor.getNome()) && Objects.equals(getFormacao(), professor.getFormacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getFormacao());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", formacao='" + formacao + '\'' +
                '}';
    }
}
