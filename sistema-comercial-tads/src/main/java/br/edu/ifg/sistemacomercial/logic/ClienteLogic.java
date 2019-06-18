package br.edu.ifg.sistemacomercial.logic;

import br.edu.ifg.sistemacomercial.dao.ClienteDAO;
import br.edu.ifg.sistemacomercial.entity.Cliente;
import br.edu.ifg.sistemacomercial.entity.Endereco;
import br.edu.ifg.sistemacomercial.util.Assert;
import br.edu.ifg.sistemacomercial.util.StringUtil;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.util.List;
import javax.inject.Inject;

public class ClienteLogic implements GenericLogic<Cliente, Integer> {

    @Inject
    private ClienteDAO dao;

    @Inject
    private EnderecoLogic enderecoLogic;

    @Override
    public Cliente salvar(Cliente entity) throws NegocioException, SistemaException {
        if ("".equals(entity.getNome().trim())) {
            throw new NegocioException("Nome do Cliente é obrigatório.");
        }
        if (StringUtil.isEmpty(entity.getCnpj())) {
            if (!Assert.isCpf(entity.getCpf())) {
                throw new NegocioException("CPF Inválido");
            }
        } else if (StringUtil.isEmpty(entity.getCpf())) {
            if (!Assert.isCnpjValido(entity.getCnpj())) {
                throw new NegocioException("CNPJ Inválido");
            }
        }

        List<Endereco> enderecos = entity.getEnderecos();
        entity.setEnderecos(null);
        entity = dao.salvar(entity);
        for (Endereco endereco : enderecos) {
            endereco.setCliente(entity);
            endereco = enderecoLogic.salvar(endereco);
        }
        entity.setEnderecos(enderecos);
        return entity;
    }

    @Override
    public void deletar(Cliente entity) throws NegocioException, SistemaException {
        dao.deletar(entity);
    }

    @Override
    public Cliente buscarPorId(Integer id) throws NegocioException, SistemaException {
        return dao.buscarPorId(id);
    }

    @Override
    public List<Cliente> buscar(Cliente entity) throws NegocioException, SistemaException {
        return dao.listar();
    }

}
