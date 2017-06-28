/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;


import Dao.FuncionarioDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Funcionario {
    private Model.Funcionario funcionario = new Model.Funcionario();

    public Model.Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Model.Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public void cadastrar() throws IOException {
        FuncionarioDAO dao = new FuncionarioDAO();
        dao.salvar(funcionario);
        
    }
    
    public void logar() throws IOException {
        FuncionarioDAO dao = new FuncionarioDAO();
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        Model.Funcionario f = dao.logar(funcionario) ;
        
        if (f != null){      
            HttpSession session = (HttpSession) context.getSession(false);    
            session.setAttribute("funcionarioLogado", f);
            
            context.redirect("Principal.xhtml");
        }else{
            FacesContext.getCurrentInstance().addMessage("y:xxx", new FacesMessage("Login ou senha incorretos!"));
        }
        
    }
    public void sair() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        session.removeAttribute("funcionarioLogado");

            context.redirect("index.xhtml");
    }
    
}




