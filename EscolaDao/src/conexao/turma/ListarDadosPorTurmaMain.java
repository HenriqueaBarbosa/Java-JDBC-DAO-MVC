package conexao.turma;

import dao.TurmaDao;
import model.Turma;

import java.util.List;

public class ListarDadosPorTurmaMain {
    public static void main(String[] args) {
        var turmaDao = new TurmaDao();

        List<Turma> dadosTurma = turmaDao.listarDadosPorTurma(1L);
        dadosTurma.forEach(System.out::println);
    }
}
