package conexao.aluno;

import dao.AlunoDao;
import model.Aluno;

public class DeletarAlunoMain {
    public static void main(String[] args) {
        var alunoDao = new AlunoDao();

        alunoDao.deletarAluno(1L);

    }
}
