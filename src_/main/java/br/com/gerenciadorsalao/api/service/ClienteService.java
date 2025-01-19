package br.com.gerenciadorsalao.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciadorsalao.api.entity.Cliente;
import br.com.gerenciadorsalao.api.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente editarCliente(Long id, Cliente cliente) {
        
        if (cliente != null) {
            cliente.setNome(cliente.getNome());
            cliente.setDataNascimento(cliente.getDataNascimento());
            cliente.setTelefone(cliente.getTelefone());
            cliente.setSexo(cliente.getSexo());
            return clienteRepository.save(cliente);
        }
        return null;
        
    }

    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }
    
}
