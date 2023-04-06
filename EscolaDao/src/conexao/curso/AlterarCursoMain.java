package conexao.curso;

import dao.CursoDao;
import model.Curso;

public class AlterarCursoMain {
    public static void main(String[] args) {
        var curso = new Curso();
        var cursoDao = new CursoDao();

        curso.setNome("C++");

        cursoDao.alterarCurso(2L, curso);
    }
}
