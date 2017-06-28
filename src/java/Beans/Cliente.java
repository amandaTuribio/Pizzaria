/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Dao.ClienteDAO;
import Dao.FuncionarioDAO;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author amanda
 */

@ManagedBean
public class Cliente {
    private Model.Cliente cliente = new Model.Cliente();

    public Model.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Model.Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    public void cadastrar() throws IOException {
        ClienteDAO dao = new ClienteDAO();
        dao.salvar(cliente);
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();           
            FacesContext.getCurrentInstance().addMessage("z:xxx", new FacesMessage("Cliente cadastrado com sucesso!"));
    }
    
    public void buscar() throws IOException {
        ClienteDAO dao = new ClienteDAO();
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        Model.Cliente c = dao.buscar(cliente) ;
        
        if (c != null){          
            FacesContext.getCurrentInstance().addMessage("p:xxx", new FacesMessage("Cliente cadastrado!"));
        }else{
            FacesContext.getCurrentInstance().addMessage("p:xxx", new FacesMessage("Cliente não cadastrado!"));
        }
        
    }
    
}
