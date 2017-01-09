/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola;

import utilizadores.Aluno;
import utilizadores.Utilizador;

/**
 *
 * @author dcsilva
 */
public class SecretariaDemo {
    public static void main(String[] args) {
        Secretaria sec = new Secretaria();
        
        Utilizador u = new Aluno();
        u.setNome("Div");
        sec.utilCriar(u);
    }
}
