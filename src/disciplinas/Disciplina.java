/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disciplinas;

import avaliacoes.Avalicao;
import avaliacoes.Regime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import utilizadores.Aluno;
import utilizadores.Professor;

/**
 *
 * @author author
 */
public class Disciplina {

    private String nome;
    private Float custo;
    private Professor profResponsavel;
    private List<Professor> profsTutores;
    private List<Aluno> alunos;
    private Date inicio;
    private Date fim;
    private Regime regime;
    private List<Avalicao> avaliacoes;

    public Disciplina() {
        iniciarListas();
    }

    public Disciplina(String nome) {
        this.nome = nome;
        iniciarListas();
    }

    public Disciplina(String nome, Professor profResponsavel, Float custo) {
        this.nome = nome;
        this.custo = custo;
        this.profResponsavel = profResponsavel;
        iniciarListas();
    }

    private void iniciarListas() {
        avaliacoes = new ArrayList<>();
        profsTutores = new ArrayList<>();
        alunos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", custo=" + custo + ", profResponsavel=" + profResponsavel + ", profsTutores=" + profsTutores + ", inicio=" + inicio + ", fim=" + fim + ", regime=" + regime + ", avaliacoes=" + avaliacoes + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.profResponsavel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.profResponsavel, other.profResponsavel)) {
            return false;
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
    }

    public Professor getProfResponsavel() {
        return profResponsavel;
    }

    public void setProfResponsavel(Professor profResponsavel) {
        this.profResponsavel = profResponsavel;
    }

    public List<Professor> getProfsTutores() {
        return profsTutores;
    }

    public void setProfsTutores(List<Professor> profsTutores) {
        this.profsTutores = profsTutores;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public List<Avalicao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avalicao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

}
