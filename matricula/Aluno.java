/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matricula;
import java.util.Random;
/**
 *
 * @author pedrogabriel.barbosa
 */
public class Aluno extends Usuario implements GeradordeMatricula
{

    public Aluno(String nome, String sobrenome, int idade) {
        super(nome, sobrenome, idade);
    }
    
    
    Random rand = new Random();
    int valor = rand.nextInt(9999);
    @Override
    public String gerarMatricula()
    {
        
         this.matricula = "A" + String.valueOf(valor);
         
         return this.matricula;
    }
}
