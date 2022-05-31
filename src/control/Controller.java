package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import model.Cadastro;
import model.Curso;
import model.Aluno;
import dao.dao;
import view.View;

public class Controller {
    
    private View view;
    private dao model;
    private Cadastro cadastro;
    
    
	public static Map<Integer, Option> opcoesByCodigos = new TreeMap<>();
	{
		for(Option o: Option.values()) {
			opcoesByCodigos.put(o.codigo, o);
		}
	}
    
	public Controller(View view, dao model) {
		this.view = view;
		this.model = model;
	}
    
	
	public void init() {
		cadastro = model.getCadastro();
		
		Option codigo = null;
		while(codigo!=Option.SAIR) {
			codigo = view.menu();
			switch (codigo) {
			case LISTA_ALUNOS: {listarAlunos(); break;}
			case LISTA_CURSOS: {listarCursos(); break;}
			case ADICIONA_ALUNO: {adicionarAluno(); break;}
			case ADICIONA_CURSO: {adicionarCurso(); break;}
			case LISTA_ALUNOS_FROM_CURSO: {listaAlunosFromCurso(); break;}
			case LISTA_CURSOS_FROM_ALUNO: {listaCursosFromAluno(); break;}
			case ADICIONA_RELACAO: {addRelacao(); break;}
			case SAIR: {terminar(); break;}
			default:
				throw new IllegalArgumentException("Unexpected value: " + codigo);
			}
		}
	}
private void listarAlunos() {
		view.listarAlunos(cadastro);
	}
	
	private void listarCursos() {
		view.listarCursos(cadastro);
	}
	
	private void adicionarAluno() {
		Aluno aluno = view.addAluno();
		this.cadastro.addAluno(aluno);
	}
	
	private void adicionarCurso() {
		Curso curso = view.addCurso();
		this.cadastro.addCurso(curso);
	}
	
	private void listaAlunosFromCurso() {
		Curso curso = view.getCursosFromLista(cadastro);
		if(curso==null) return;
		view.listarAlunosFromCurso(cadastro, curso);
	}
	
	
	private void listaCursosFromAluno() {
		Aluno aluno = view.getAlunoFromLista(cadastro);
		if(aluno==null) return;
		view.listarCursosfromAluno(cadastro, aluno);
	}
	
	private void addRelacao() {
		Aluno aluno = view.getAlunoFromLista(cadastro);
		if(aluno==null) return;
		Curso curso = view.getCursosFromLista(cadastro);
		if(curso==null) return;
		cadastro.addRelacaoAlunoCurso(aluno, curso);
		
	}
	
	private void terminar() {
		model.saveCadastro(cadastro);
	}



}
