package conexao.aluno;

import dao.AlunoDao;
import model.Aluno;

public class MatricularAlunoMain {
    public static void main(String[] args) {
        var aluno = new Aluno();
        var alunoDao = new AlunoDao();

        aluno.setNome("Henrique");
        aluno.setIdade(25);
        aluno.setEndereco("Rua A, 123");

        alunoDao.matricularAluno(aluno);
    }
}
