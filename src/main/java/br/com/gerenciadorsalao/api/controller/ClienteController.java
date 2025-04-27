package br.com.gerenciadorsalao.api.controller;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciadorsalao.api.entity.Cliente;
import br.com.gerenciadorsalao.api.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    //get cliente by id
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        return clienteService.listarClientes().stream().filter(cliente -> cliente.getId() == id).findFirst().orElse(null);
    }
    
    @PostMapping("/")
    public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }
    
    @GetMapping("/")
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
    
    
    @PutMapping("/{id}")
    public Cliente editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.editarCliente(id, cliente);
    } 
  
    @DeleteMapping("/{id}")
    public void removerCliente(@PathVariable Long id) {
        clienteService.removerCliente(id);
    }

 }
