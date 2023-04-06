package conexao.curso;

import dao.CursoDao;
import model.Curso;

public class RegistrarCursoMain {
    public static void main(String[] args) {
        var curso = new Curso();
        var cursoDao = new CursoDao();

        curso.setNome("Java");

        cursoDao.registarCurso(curso);
    }
}
