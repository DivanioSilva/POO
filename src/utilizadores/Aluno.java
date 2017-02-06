/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilizadores;

/**
 *
 * @author author
 */
public class Aluno extends Utilizador {
    
    public Aluno() {
        this.setTipo(TipoUtilizador.Aluno);
    }    

    public Aluno(String Nome, int idade, String telemovel, String email, String morada, String username, String password) {
        super(Nome, idade, telemovel, email, morada, username, password);
    }

    public Aluno(String Nome) {
        super(Nome);
    }
}
