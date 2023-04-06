package conexao.professor;

import dao.ProfessorDao;
import model.Professor;

import java.util.List;

public class ListarProfessoresMain {
    public static void main(String[] args) {
        var professorDao = new ProfessorDao();

        List<Professor> professoresListados = professorDao.listarProfessores();
        professoresListados.forEach(System.out::println);
    }
}
