package br.com.fiap.dao;

import br.com.fiap.dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    private Connection con;
    public ClienteDAO(Connection con){
        this.con = con;
    }

    public  Connection getCon(){
        return con;
    }

    public String inserir (Cliente cliente){
        String sql = "insert into ddd_cliente(id, nome, placa) values (?, ?, ?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);){
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNomeCliente());
            ps.setString(3, cliente.getPlaca());
            if (ps.executeUpdate()>0){
                return "Inserido com sucesso!";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL:" + e.getMessage();
        }
    }



}
