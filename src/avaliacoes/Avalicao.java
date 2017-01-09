/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacoes;

import java.util.Date;

/**
 *
 * @author author
 */
public class Avalicao {

    private String nome;
    private Date data;
    private TipoAvalicao tipo;
//    private Regime regime;
    private Float peso;

    @Override
    public String toString() {
        return "Avalicao{" + "nome=" + nome + ", data=" + data + ", tipo=" + tipo + ", peso=" + peso + '}';
    }

    public Avalicao() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoAvalicao getTipo() {
        return tipo;
    }

    public void setTipo(TipoAvalicao tipo) {
        this.tipo = tipo;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }
}
