/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author amanda
 */
@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private double valor;
    private Integer mesa;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
    private Integer status;
    private Integer local;
    
    private Cliente cliente;
    
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ItemPedido> itempedido = new HashSet<ItemPedido>();

    public Pedido() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getDate() {
        return new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm").format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<ItemPedido> getItempedido() {
        return itempedido;
    }

    public void setItempedido(Set<ItemPedido> itempedido) {
        this.itempedido = itempedido;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLocal() {
        return local;
    }

    public void setLocal(Integer local) {
        this.local = local;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
        

    
}