package conexao.aluno;

import dao.AlunoDao;
import model.Aluno;

public class MatricularAlunoMain {
    public static void main(String[] args) {
        var aluno = new Aluno();
        var alunoDao = new AlunoDao();

        aluno.setNome("Lucas");
        aluno.setIdade(27);
        aluno.setEndereco("Rua F, 1923");

        alunoDao.matricularAluno(aluno);
    }
}
