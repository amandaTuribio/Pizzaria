/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author amanda
 */
public class ClienteDAO {

    public void salvar(Cliente cliente) {
        Session daoSession = DAO.getSession();
        Transaction transaction = daoSession.getTransaction();           
        
        transaction.begin();
        if(cliente == null) return;
        daoSession.save(cliente);
        transaction.commit();
        daoSession.close();
    }

    public Cliente buscar(Cliente cliente) {
        Session daoSession = DAO.getSession();        
        Criteria cri = daoSession.createCriteria(Model.Cliente.class);

        cri.add(Restrictions.ilike("telefone", cliente.getTelefone()));
        Cliente c = (Cliente) cri.uniqueResult() ;
        daoSession.close();
        if(c == null) return null;      
        return c;
    }
}
