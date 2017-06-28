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
import javax.faces.context.FacesContext;


/**
 *
 * @author amanda
 */
@ManagedBean
public class Pedido {

    private Model.Pedido pedido = new Model.Pedido();
    private ArrayList<Model.Pedido> lista = new ArrayList<>();

    public Pedido() {
    }

    public Model.Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Model.Pedido pedido) {
        this.pedido = pedido;
    }
    
    public ArrayList<Model.Pedido> getLista() {
        procurar();
        return lista;
    }

    public void setLista(ArrayList<Model.Pedido> lista) {
        this.lista = lista;
    }

    public void procurar() {
        PedidoDAO dao = new PedidoDAO();

        lista = (ArrayList<Model.Pedido>) dao.lista();
    }
    
}



