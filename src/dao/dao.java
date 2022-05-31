package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import model.Aluno;
import model.Curso;
import model.Cadastro;

public class dao {
    
    private String alunoPath;
    private String cursoPath;
    private String relacaoPath;
    
    private Cadastro cadastroInput;

    public dao(String aAlunoPath, String aCursoPath, String aRelacaoPath){
		this.alunoPath = aAlunoPath;
		this.cursoPath = aCursoPath;
                this.relacaoPath = aRelacaoPath;
}
public Cadastro getCadastro(){
   this.cadastroInput = new Cadastro();
   
    loadAlunos();
    loadCursos();

   return loadRelacoes();
        
}
private Cadastro loadRelacoes(){
    
    
        try (   InputStream is = new FileInputStream(this.relacaoPath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String idAluno = palavras[0];
                String nomeCurso = palavras[1];
                String anoCurso = palavras[1];
                String nivelCurso = palavras[2];
                
             Curso curso = new Curso(nomeCurso, anoCurso, nivelCurso);
             Aluno aluno = this.cadastroInput.getAlunoFromId(idAluno);
            cadastroInput.addRelacaoAlunoCurso(aluno, curso);

            }

        }catch(IOException e){
            e.printStackTrace();
        }
 return this.cadastroInput;
    }

private void loadAlunos(){
    try (   InputStream is = new FileInputStream(this.alunoPath);
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String id = palavras[0];
                String nome = palavras[1];

                Aluno aluno = new Aluno(id, nome);
                this.cadastroInput.addAluno(aluno);

            }

        }catch(IOException e){
            e.printStackTrace();
        }
    
}

private void loadCursos(){

        try (   InputStream is = new FileInputStream(this.cursoPath);
                InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);
            ){
            String linha;
            int i=0;
            while((linha = br.readLine()) != null){

                String[] palavras = linha.split(",");

                String nome = palavras[0];
                String Ano = palavras[1];
                String Nivel = palavras[2];
                
                Curso curso = new Curso(nome, Ano, Nivel);
                this.cadastroInput.addCurso(curso);

            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    
	
	
	
	public void saveCadastro(Cadastro cadastroOutput){
		
		saveAlunos(cadastroOutput.getAlunos());
		saveCurso(cadastroOutput.getCursos());
		saveRelacoes(cadastroOutput);

    }

	private void saveRelacoes(Cadastro cadastroOutput){

        try(    OutputStream os = new FileOutputStream(this.relacaoPath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Aluno aluno: cadastroOutput.getAlunos()){
                for(Curso curso: cadastroOutput.getCursosFromAluno(aluno.getId())){
                    pw.println(aluno.getId()+","+curso.getNome()+","+curso.getAno()+"," +curso.getNivel());
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }

	private void saveAlunos(Set<Aluno> alunosOutput){

        try(    OutputStream os = new FileOutputStream(this.alunoPath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Aluno aluno: alunosOutput){
                pw.println(aluno.getId()+","+aluno.getNome());
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }


	private void saveCurso(Set<Curso> cursoutput){

        try(    OutputStream os = new FileOutputStream(this.cursoPath);
                OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(osw, true);
                ){
            for(Curso curso: cursoutput){
                pw.println(curso.getNome()+","+curso.getAno()+","+curso.getNivel()  );
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }



}