/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PICHAU
 */
public class Aluno {
    private String id;
    private String nome;

    public Aluno(String Id, String nome){
                this.id = id;
		this.nome = nome;
}
 

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

       
	public int compareTo(Aluno o) {
		return this.id.compareTo(o.id);
	}

	
	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + "]";
	}








}
