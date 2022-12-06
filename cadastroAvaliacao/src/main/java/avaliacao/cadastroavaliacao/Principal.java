/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avaliacao.cadastroavaliacao;

/**
 *
 * @author Louise
 */
public class Principal {
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private String tipoContato;
    private String lista; 

    public Principal(Integer id, String nome, String telefone, String email, String tipoContato) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.tipoContato = tipoContato;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }
    
    
    
    
    
}
