package view;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import control.Controller;
import control.Option;
import model.Cadastro;
import model.Curso;
import model.Aluno;

public class ViewTerminal implements View{
    @Override
    public Option menu() {
		try {
			
			System.out.println("Entre com uma das opcoes:");
			for(Option o: Option.values()) {
				System.out.println("" + o.codigo + " - " + o.descricao);
			}
			
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			try {
				String entrada = in.nextLine();
				int opcaoCodigo = Integer.parseInt(entrada);
				
				if(!Controller.opcoesByCodigos.keySet().contains(opcaoCodigo)) {
					throw new InputMismatchException("Opcao nao corresponde a nenhum codigo listado");
				}
				return Controller.opcoesByCodigos.get(opcaoCodigo);
				
			}catch(NumberFormatException e) {
				throw new InputMismatchException("Opcao entrada nao eh um numero inteiro");
			}
		}catch(InputMismatchException e) {
			System.out.println(e.getMessage());
			menu();
		}
		return null;
			
	}

		@Override
	public void listarAlunos(Cadastro cadastro) {
		System.out.println("Todos os Alunos cadastrados:");
		for(Aluno f: cadastro.getAlunos()) {
			System.out.println(f);
		}
	}

	
    @Override
	public void listarCursos(Cadastro cadastro) {
		System.out.println("Todos os Cursos cadastrados:");
		for(Curso d: cadastro.getCursos()) {
			System.out.println(d);
		}
	}
	
    @Override
	public void listarAlunosFromCurso(Cadastro cadastro, Curso curso) {
		System.out.println("Todos os Alunos do curso " + curso + ":");
		for(Aluno f: cadastro.getAlunosFromCurso(curso)) {
			System.out.println(f);
		}
	}

	
    @Override
	public void listarCursosfromAluno(Cadastro cadastro, Aluno aluno) {
		System.out.println("Todos os Alunos do curso " + aluno + ":");
		for(Curso d: cadastro.getCursosFromAluno(aluno.getId())) {
			System.out.println(d);
		}
	}



	
    @Override
	public Curso addCurso() {
		return getNewCurso();
	}

	
    @Override
	public Aluno addAluno() {
		return getNewAluno();
	}

	
    @Override
	public Curso getCursosFromLista(Cadastro cadastro) {
		System.out.println("Escolha um curso");
		Curso curso = escolherCurso(cadastro);
		if(!cadastro.getCursos().contains(curso)) {
			System.out.println("Nao existe o curso com as informacoes entradas");
			return null;
		}
		
		return curso;
	}

	
    @Override
	public Aluno getAlunoFromLista(Cadastro cadastro) {
		System.out.println("Entre com o id do Aluno");
		listarAlunos(cadastro);
		System.out.println("Entre com o id do Aluno");
		String id = getString();
		
		Aluno aluno = cadastro.getAlunoFromId(id);
		if(aluno==null) {
			System.out.println("Nao existe o id deste aluno");
		}
		
		return aluno;
	}

	
	
	public Aluno getNewAluno() {
		System.out.println("Entre com os dados do aluno");
		String id = getIdAluno();
		String nome = getNomeAluno();
		return new Aluno(id, nome);
	}
	
	public String getIdAluno() {
		System.out.println("Entre com o id do aluno");
		return getString();
	}
	
	public String getNomeAluno() {
		System.out.println("Entre com a nome do aluno");
		return getString();
	}
	
	
	
	public Curso getNewCurso() {
		System.out.println("Entre com os dados do curso");
		String nome = getNomeCurso();
		String Ano = getAnoCurso();
                String Nivel = getNivelCurso();
		return new Curso(nome, Ano , Nivel);
	}
	
	public String getNomeCurso() {
		System.out.println("Entre com o nome do curso");
		return getString();
	}
	
	public String getAnoCurso() {
		System.out.println("Entre com o ano do curso");
		return getString();
	}
	
        public String getNivelCurso() {
		System.out.println("Entre com o nivel do Curso");
		return getString();
	}
	
	private Curso escolherCurso(Cadastro cadastro) {
		String nome = escolherNomesCurso(cadastro);
		String ano = escolherAnoDepartamentos(cadastro);
		String nivel = escolherNiveisCurso(cadastro);
                return new Curso(nome, ano, nivel);
	}
	
	private String escolherAnoDepartamentos(Cadastro cadastro) {
		Set<String> anos = new TreeSet<>();
		for(Curso d: cadastro.getCursos()) {
			anos.add(d.getAno());
		}
		System.out.println("Escolha um dos anos");
		for(String ano: anos) {
			System.out.println(ano);
		}
		System.out.println("Entre com a cidade escolhida:");
		return getString();
	}
	
	private String escolherNomesCurso(Cadastro cadastro) {
		Set<String> nomes = new TreeSet<>();
		for(Curso d: cadastro.getCursos()) {
			nomes.add(d.getNome());
		}
		System.out.println("Escolha um dos nome");
		for(String nome: nomes) {
			System.out.println(nome);
		}
		System.out.println("Entre com o nome escolhida:");
		return getString();
	
        }
        private String escolherNiveisCurso(Cadastro cadastro) {
		Set<String> niveis = new TreeSet<>();
		for(Curso d: cadastro.getCursos()) {
			niveis.add(d.getNivel());
		}
		System.out.println("Escolha um dos niveis");
		for(String nivel: niveis) {
			System.out.println(nivel);
		}
		System.out.println("Entre com o nivel escolhida:");
		return getString();
	
        }
	
	public String getString() {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		return str.trim();
	}
}

