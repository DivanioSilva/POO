/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escola;

import disciplinas.Disciplina;
import java.util.ArrayList;
import java.util.List;
import utilizadores.Aluno;
import utilizadores.Utilizador;

/**
 *
 * @author dcsilva
 */
public class Secretaria {

    private List<Utilizador> utilizadores;
    private Disciplina disciplina;
    private List<Disciplina> disciplinas;

    public Secretaria() {
        this.utilizadores = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    //UtilCriar
    public void utilCriar(Utilizador utilizador) {
        this.utilizadores.add(utilizador);
        utilListar();
    }

    private void utilListar() {
        System.out.println("Tenho " + utilizadores.size() + " utilizadores cadastados.");
        
        this.utilizadores.forEach(u -> System.out.println(u));
    }

    //UtilRemover
    public void utilRemover(Utilizador utilizador) {
        this.utilizadores.remove(utilizador);
    }

    //UtilEditar
    public void utilEditar(Utilizador utilizador) {
        for (Utilizador u : utilizadores) {
            if (u.equals(utilizador)) {
                u = utilizador;
            }
        }
    }

    //DiscCriar
    /**
     * Método para criar disciplinas
     * @param disciplina1 
     */
    public void disciplinaCriar(Disciplina disciplina1) {
//        this.disciplina = disciplina1;
        this.disciplinas.add(disciplina1);
    }

    /**
     * Adicionar utilizador à disciplina
     *
     * @param disciplina
     * @param aluno
     */
    public void disciplinaAddUtilizador(Disciplina disciplina, Aluno aluno) {
        this.disciplina.getAlunos().add(aluno);
    }

    /**
     * Método para remover utiliazador
     * @param disciplina
     * @param aluno 
     */
    public void disciplinaRemoverUtilizador(Disciplina disciplina, Aluno aluno) {
        if (disciplina.equals(this)) {
            this.disciplina.getAlunos().remove(aluno);
        }
    }

    //DiscRemover
    /**
     * 
     * @param disciplina 
     */
    public void disciplinaDelete(Disciplina disciplina) {
        if (disciplina.equals(this)) {
            this.disciplina = null;
        }
    }

    //DiscEditar
    //GrupoCriar
    //GrupoRemover
    //GrupoEditar
    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
