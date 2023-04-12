package model;

import java.util.Objects;
import java.util.Optional;

public class Turma {
    private Long id;
    private Aluno aluno;
    private Professor professor;
    private Curso curso;

    public Turma() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma turma)) return false;
        return Objects.equals(getId(), turma.getId()) && Objects.equals(getAluno(), turma.getAluno()) && Objects.equals(getProfessor(), turma.getProfessor()) && Objects.equals(getCurso(), turma.getCurso());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAluno(), getProfessor(), getCurso());
    }

    @Override
    public String toString() {
        return "Turma{" +
                "número=" + id +
                ", aluno=" + Optional.ofNullable(aluno).flatMap(a -> Optional.ofNullable(a.getNome())).orElse("") +
                ", professor=" + Optional.ofNullable(professor).flatMap(p -> Optional.ofNullable(p.getNome())).orElse("") +
                ", curso=" + Optional.ofNullable(curso).flatMap(c -> Optional.ofNullable(c.getNome())).orElse("") +
                '}';
    }

}
