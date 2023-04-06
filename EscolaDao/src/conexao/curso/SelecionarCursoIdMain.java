package conexao.curso;

import dao.CursoDao;
import model.Curso;

public class SelecionarCursoIdMain {
    public static void main(String[] args) {
        var cursoDao = new CursoDao();

        Curso cursoSelecionado = cursoDao.selecionarCursoId(2L);
        System.out.println(cursoSelecionado);
    }
}
