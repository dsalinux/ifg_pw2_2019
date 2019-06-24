/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.sistemacomercial.entity;

/**
 *
 * @author Daniela
 */
   public enum TipoMovimento{
        ENTRADA ("Entrada"),
        SAÍDA("Saída");
        
        private String nome;
        
        private TipoMovimento(String nome){
            this.nome=nome;
        }
        
        public String getNome(){
        return nome;
    }
        
}