/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacoes;

import disciplinas.Disciplina;
import java.util.Date;
import utilizadores.Professor;

/**
 *
 * @author author
 */
public class AvalicaoDemo {
    
    public static void main(String[] args) {
        Avalicao av = new Avalicao();
        av.setData(new Date());
        av.setNome("Primeiroa avaliação");
        av.setPeso(50F);
        av.setTipo(TipoAvalicao.CONTINUA);
//        av.setRegime(Regime.PRESENCIAL);
        
        Disciplina disc = new Disciplina("POO");
        disc.setCusto(150F);
        
        disc.setRegime(Regime.PRESENCIAL);
        disc.setProfResponsavel(new Professor("Paulo Cabrita", 43, "99993333", "pjc@ual.pt", "Odivelas", "pjc", "FCP"));
        disc.setFim(new Date());
        disc.setInicio(new Date());
        disc.getProfsTutores().add(new Professor("Divanio Silva"));
        disc.getProfsTutores().add(new Professor("Enes da Silveira"));
        disc.getProfsTutores().add(new Professor("Joaquim Viana"));
        disc.getAvaliacoes().add(av);
        
        System.out.println(disc);
    }
}
