/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Funcionario;
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
public class ProdutoDAO {
       
    public void salvar(Produto produto) {
        Session daoSession = DAO.getSession();
        Transaction transaction = daoSession.getTransaction();           
        
        transaction.begin();
        if(produto == null) return;
        daoSession.save(produto);
        transaction.commit();
        daoSession.close();
    }
    
    public List<Produto> lista() {
       Session daoSession = DAO.getSession();
       
        Criteria criteria = daoSession.createCriteria(Model.Produto.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        ArrayList lista = (ArrayList<Model.Produto>) criteria.list();
        
        daoSession.close();
        return lista;
    }

    public List<Produto> getProduto() {
        Session daoSession = DAO.getSession();
       
        Criteria criteria = daoSession.createCriteria(Model.Produto.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        ArrayList lista = (ArrayList<Model.Produto>) criteria.list();
        
        daoSession.close();
        return lista;
    }
}
