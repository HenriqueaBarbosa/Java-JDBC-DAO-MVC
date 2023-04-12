package conexao.turma;

import dao.TurmaDao;

public class InserirDadosTurmaMain {
    public static void main(String[] args) {

        var turmaDao = new TurmaDao();

        turmaDao.inserirDadosTurma(1L, 4L, 7L, 6L);
        turmaDao.inserirDadosTurma(1L, 5L, 8L, 7L);
        turmaDao.inserirDadosTurma(1L, 6L, 9L, 8L);
    }
}
