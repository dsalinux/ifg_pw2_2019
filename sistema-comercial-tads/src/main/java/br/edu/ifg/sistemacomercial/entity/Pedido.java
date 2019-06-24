package br.edu.ifg.sistemacomercial.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_pedido")
    private Date dataPedido;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cancelamento")
    private Date dataCancelamento;

    private String observacoes;
    @Column(name = "observacoes_cliente")
    private String observacoesCliente;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoHasProduto> pedidosHasProdutos;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Double desconto;

    public Pedido() {
        this.dataPedido = new Date();
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Date getDataCancelamento() {
        return dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) {
        this.dataCancelamento = dataCancelamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getObservacoesCliente() {
        return observacoesCliente;
    }

    public void setObservacoesCliente(String observacoesCliente) {
        this.observacoesCliente = observacoesCliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public List<PedidoHasProduto> getPedidosHasProdutos() {
        return pedidosHasProdutos;
    }

    public void setPedidosHasProdutos(List<PedidoHasProduto> pedidosHasProdutos) {
        this.pedidosHasProdutos = pedidosHasProdutos;
    }

    public Double getTotal() {
        Double total = 0D;
        if (getPedidosHasProdutos() != null) {
            for (PedidoHasProduto entity : getPedidosHasProdutos()) {
                total += entity.getValor() * entity.getQuantidade();
            }
        }
        return total;
    }
    
    public Double getTotalFinal() {
        Double desconto = getDesconto() != null?getDesconto():0D;
        Double total = 0D;
        total = getTotal() - desconto;
        return total;
    }
    
 

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
