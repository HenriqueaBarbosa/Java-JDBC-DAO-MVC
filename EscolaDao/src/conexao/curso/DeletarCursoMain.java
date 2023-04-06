package conexao.curso;

import dao.CursoDao;

public class DeletarCursoMain {
    public static void main(String[] args) {
        var cursoDao = new CursoDao();

        cursoDao.deletarCurso(1L);
    }
}
