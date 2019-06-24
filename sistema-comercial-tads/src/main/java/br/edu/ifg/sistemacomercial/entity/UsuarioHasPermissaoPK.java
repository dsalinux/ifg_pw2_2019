
package br.edu.ifg.sistemacomercial.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioHasPermissaoPK implements Serializable {
    
    private static final long serialVersionUID = -637018809489152388L;

    
    private Long usuario_id;
    private Long permissao_id;

    public Long getPermissao_id() {
        return permissao_id;
    }

    public void setPermissao_id(Long permissao_id) {
        this.permissao_id = permissao_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    
   
    
}
