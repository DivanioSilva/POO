/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilizadores;

/**
 *
 * @author dcsilva
 */
public class Professor extends Utilizador {

    public Professor() {
        super.setTipo(TipoUtilizador.Professor);
    }

    public Professor(String Nome, int idade, String telemovel, String email, String morada, String username, String password) {
        super(Nome, idade, telemovel, email, morada, username, password);
        super.setTipo(TipoUtilizador.Professor);
    }

    public Professor(String Nome) {
        super(Nome);
        super.setTipo(TipoUtilizador.Professor);
    }

    @Override
    public String toString() {
        return super.getNome();
    }

}
