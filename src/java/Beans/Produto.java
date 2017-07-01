/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import Dao.PedidoDAO;
import Dao.ProdutoDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


@ManagedBean
public class Produto {
    private Model.Produto produto = new Model.Produto();
    private List<Model.Produto> lista;

    public Produto() {
    }

    public Model.Produto getProduto() {
        return produto;
    }

    public void setProduto(Model.Produto produto) {
        this.produto = produto;
    }

    public void cadastrar() throws IOException {
        ProdutoDAO dao = new ProdutoDAO();
        dao.salvar(produto);
        FacesContext.getCurrentInstance().addMessage("y:x", new FacesMessage("Produto Cadastrado!"));

    }
    
    public List<Model.Produto> getLista() {
        procurar();
        return lista;
    }

    public void setLista(ArrayList<Model.Produto> lista) {
        this.lista = lista;
    }

    public void procurar() {
        ProdutoDAO dao = new ProdutoDAO();

        lista = dao.lista();
    }
    
    public String toString() {  
        return String.valueOf(produto.getDescricao());  
    }   
    
    
}
