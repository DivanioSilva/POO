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
public class Utilizador {

    private String Nome;
    private int idade;
    private String telemovel;
    private String email;
    private String morada;
    private String username;
    private String password;
    private TipoUtilizador tipo;

    public Utilizador() {
    }

    public Utilizador(String Nome, int idade, String telemovel, String email, String morada, String username, String password) {
        this.Nome = Nome;
        this.idade = idade;
        this.telemovel = telemovel;
        this.email = email;
        this.morada = morada;
        this.username = username;
        this.password = password;
    }

    public Utilizador(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "Nome=" + Nome + ", idade=" + idade + ", telemovel=" + telemovel + ", email=" + email + ", morada=" + morada + ", username=" + username + ", password=" + password + ", tipo=" + tipo + '}';
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUtilizador getTipo() {
        return tipo;
    }

    public void setTipo(TipoUtilizador tipo) {
        this.tipo = tipo;
    }

}
