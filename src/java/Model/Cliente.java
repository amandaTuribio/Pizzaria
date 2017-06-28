/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author amanda
 */
@Entity
public class Cliente implements Serializable {
 

    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String telefone;
    private String endereco;
    private String pontref;

    public Cliente() {
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPontref() {
        return pontref;
    }

    public void setPontref(String pontref) {
        this.pontref = pontref;
    }
      
}
