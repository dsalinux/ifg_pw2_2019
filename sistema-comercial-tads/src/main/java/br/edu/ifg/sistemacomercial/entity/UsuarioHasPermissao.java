package br.edu.ifg.sistemacomercial.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_has_permissao")
public class UsuarioHasPermissao implements Serializable {
    
    @EmbeddedId
    private UsuarioHasPermissaoPK id;

    public UsuarioHasPermissaoPK getId() {
        return id;
    }

    public void setId(UsuarioHasPermissaoPK id) {
        this.id = id;
    }
    
    
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final UsuarioHasPermissao other = (UsuarioHasPermissao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
