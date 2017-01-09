
import java.util.ArrayList;
import java.util.List;
import utilizadores.Utilizador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dcsilva
 */
public class Grupo {

    private List<Utilizador> utilizadores;

    public Grupo() {
        utilizadores = new ArrayList<>();
    }

    public void adicionarUtilizador(Utilizador utilizador) {
        utilizadores.add(utilizador);
    }

    public List<Utilizador> getUtilizadores() {
        return utilizadores;
    }

    public void setUtilizadores(List<Utilizador> utilizadores) {
        this.utilizadores = utilizadores;
    }

}
