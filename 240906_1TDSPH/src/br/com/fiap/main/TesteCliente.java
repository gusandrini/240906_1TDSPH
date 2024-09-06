package br.com.fiap.main;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.ConnectionFactory;
import br.com.fiap.dto.Cliente;

import java.sql.Connection;

public class TesteCliente {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();
        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        cliente.setIdCliente(157);
        cliente.setNomeCliente("Gustavo");
        cliente.setPlaca("GOT2005");
        System.out.println(clienteDAO.inserir(cliente));
        ConnectionFactory.fecharConexao(con);
    }
}
