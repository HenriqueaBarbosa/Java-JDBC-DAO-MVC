package conexao.aluno;

import dao.AlunoDao;
import model.Aluno;

public class AlterarAlunoMain {
    public static void main(String[] args) {
        var aluno = new Aluno();
        var alunoDao = new AlunoDao();

        aluno.setNome("Mateus");
        aluno.setIdade(35);
        aluno.setEndereco("Rua Z, 321");

        alunoDao.alterarAluno(1L,aluno);
    }


}
