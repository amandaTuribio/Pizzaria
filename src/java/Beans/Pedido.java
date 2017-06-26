/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author amanda
 */
@ManagedBean
public class Pedido {
    private Model.Pedido pedidoselecionado = new Model.Pedido();

    public Pedido() {
    }

    public Model.Pedido getPedidoselecionado() {
        return pedidoselecionado;
    }

    public void setPedidoselecionado(Model.Pedido pedidoselecionado) {
        this.pedidoselecionado = pedidoselecionado;
    }
           

}
