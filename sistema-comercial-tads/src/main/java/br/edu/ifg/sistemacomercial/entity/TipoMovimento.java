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