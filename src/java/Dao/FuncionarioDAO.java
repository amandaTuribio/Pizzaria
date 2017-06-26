/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Funcionario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author amanda
 */

public class FuncionarioDAO {

    public void salvar(Funcionario funcionario) {
        Session daoSession = DAO.getSession();
        Transaction transaction = daoSession.getTransaction();           
        
        transaction.begin();
        if(funcionario == null) return;
        if(funcionario.getSenha() == null) return;
        daoSession.save(funcionario);
        transaction.commit();
        daoSession.close();
    }
    
    public Funcionario logar(Funcionario funcionario) {
        Session daoSession = DAO.getSession();        
        Criteria cri = daoSession.createCriteria(Model.Funcionario.class);

        cri.add(Restrictions.ilike("login", funcionario.getLogin()));
        cri.add(Restrictions.ilike("senha", funcionario.getSenha()));
        Funcionario f = (Funcionario) cri.uniqueResult() ;
        daoSession.close();
        if(f == null) return null;      
        return f;
    }
    
}
