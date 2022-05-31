package view;

import control.Option;
import model.Cadastro;
import model.Aluno;
import model.Curso;

public interface View {
    Option menu();
    
    void listarAlunos(Cadastro cadastro);
    void listarCursos(Cadastro cadastro);
    
    void listarAlunosFromCurso(Cadastro cadastro, Curso curso);
    void listarCursosfromAluno(Cadastro cadastro, Aluno aluno);
    
    Curso addCurso();
    Aluno addAluno();
    
    Curso getCursosFromLista(Cadastro cadastro);
    Aluno getAlunoFromLista(Cadastro cadastro);

    
    
    
    
}
