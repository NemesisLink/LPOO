/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PICHAU
 */
public class Curso {
	
	private String nome;
	
        private String nivel;
        
        private String Ano;
        
	
	public Curso(String nome, String Ano) {
		super();
		this.nome = nome;
		this.Ano = Ano;
	        this.nivel = nivel;
        }

    public Curso(String nome, String Ano, String Nivel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
       public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getAno() {
		return Ano;
	}

	public void setAno(String Ano) {
		this.Ano = Ano;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;   
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public int compareTo(Curso o) {
			return this.nome.compareTo(o.nome);
	}
	

	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", cidade=" + Ano + "nível="+ nivel + "]";
	}


}

