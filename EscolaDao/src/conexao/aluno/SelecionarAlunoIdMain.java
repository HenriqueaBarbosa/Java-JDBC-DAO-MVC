package conexao.aluno;

import dao.AlunoDao;
import model.Aluno;

public class SelecionarAlunoIdMain {
    public static void main(String[] args) {
        var alunoDao = new AlunoDao();

        Aluno alunoSelecionado = alunoDao.selecionarAlunoId(2L);
        System.out.println(alunoSelecionado);
    }
}
