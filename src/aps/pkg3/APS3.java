/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aps.pkg3;

import control.Controller;
import dao.dao;
import view.View;
import view.ViewTerminal;
/**
 *
 * @author PICHAU
 */
public class APS3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
    
    View view = new ViewTerminal();
		String alunoPath = "files/alunos.csv";
		String cursoPath = "files/cursos.csv";
		String relacaoPath = "files/alunos_cursos.csv";
		dao model = new dao(alunoPath, cursoPath, relacaoPath);
		
		new Controller(view, model).init();
    
    
    
    
    }
    
}
