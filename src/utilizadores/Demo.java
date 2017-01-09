/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilizadores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dcsilva
 */
public class Demo {

    public static void main(String[] args) {
        Aluno a = new Aluno();
        a.setNome("Gulherme");

        Professor p = new Professor("Paulo Cabrita");

        System.out.println(p);

        p.setIdade(33);
        p.setMorada("Lisboa");
        System.out.println(p);
        p.setMorada("Loures");
        System.out.println(p);
    }
}
