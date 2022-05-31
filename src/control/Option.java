/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author PICHAU
 */
public enum Option {
        LISTA_ALUNOS(1, "Listar todos os alunos cadastrados"), 
	LISTA_CURSOS(2, "Listar todos os cursos cadastrados"), 
	LISTA_ALUNOS_FROM_CURSO(3, "Listar todos os alunos de um curso escolhido"), 
	LISTA_CURSOS_FROM_ALUNO(4, "Listar todos os cursos que um aluno escolhido trabalha"),
	ADICIONA_ALUNO(5, "Cadastrar um aluno"),
	ADICIONA_CURSO(6, "Cadastrar um novo curso"),
	ADICIONA_RELACAO(7, "Adicionar uma relacao entre um aluno e um curso"),
	SAIR(0, "Sair do programa e salvar os dados");
	
	public String descricao;
	public int codigo;
	
	private Option(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
