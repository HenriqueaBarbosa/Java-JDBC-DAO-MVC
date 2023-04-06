package conexao.aluno;

import dao.AlunoDao;
import model.Aluno;

import java.util.List;

public class ListarAlunosMain {
    public static void main(String[] args) {
        var aluno = new Aluno();
        var alunoDao = new AlunoDao();

        List<Aluno> alunosListados = alunoDao.listarAlunos();
        alunosListados.forEach(System.out::println);
    }
}
