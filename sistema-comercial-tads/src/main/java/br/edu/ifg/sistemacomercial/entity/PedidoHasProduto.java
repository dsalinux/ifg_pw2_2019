package br.edu.ifg.sistemacomercial.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido_has_produto")
public class PedidoHasProduto implements Serializable {

    @EmbeddedId
    private PedidoHasProdutoPk id;

    private Double valor;
    private Double quantidade;

    @ManyToOne
    @JoinColumn(updatable = false, insertable = false, name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(updatable = false, insertable = false, name = "pedido_id")
    private Pedido pedido;
    
    public PedidoHasProdutoPk getId() {
        return id;
    }

    public void setId(PedidoHasProdutoPk id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if(id == null){
            id =  new PedidoHasProdutoPk();
        }
        id.setProdutoId(produto.getId());
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        if(id == null){
            id =  new PedidoHasProdutoPk();
        }
        id.setPedidoId(pedido.getId());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final PedidoHasProduto other = (PedidoHasProduto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
