package conexao.curso;

import dao.CursoDao;
import model.Curso;

import java.util.List;

public class ListarCursosMain {
    public static void main(String[] args) {
        var cursoDao = new CursoDao();

        List<Curso> cursosListados = cursoDao.listarCursos();
        cursosListados.forEach(System.out::println);
    }
}
