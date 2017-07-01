/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Pedido;
import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author amanda
 */
public class PedidoDAO {
 
    public List<Pedido> lista() {
       Session daoSession = DAO.getSession();
       
        Criteria criteria = daoSession.createCriteria(Model.Pedido.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        ArrayList lista = (ArrayList<Model.Pedido>) criteria.list();
        
        daoSession.close();
        return lista;
    }

    public void salvar(Pedido pedido) {
         Session daoSession = DAO.getSession();
        Transaction transaction = daoSession.getTransaction();           
        
        transaction.begin();
        if(pedido == null) return;
        daoSession.save(pedido);
        transaction.commit();
        daoSession.close();

    }
}
