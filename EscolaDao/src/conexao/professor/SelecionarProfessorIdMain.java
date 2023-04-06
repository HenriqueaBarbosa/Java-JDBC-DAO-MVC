package conexao.professor;

import dao.ProfessorDao;
import model.Professor;

public class SelecionarProfessorIdMain {
    public static void main(String[] args) {

        var professorDao = new ProfessorDao();

        Professor professorSelecionado = professorDao.selecionarProfessorId(2L);
        System.out.println(professorSelecionado);
    }
}
