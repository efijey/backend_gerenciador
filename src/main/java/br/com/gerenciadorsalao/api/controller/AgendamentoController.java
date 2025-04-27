package br.com.gerenciadorsalao.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciadorsalao.api.entity.Agendamento;
import br.com.gerenciadorsalao.api.enums.StatusAgendamento;
import br.com.gerenciadorsalao.api.service.AgendamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    
    @PostMapping("/criar")
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        return agendamentoService.criarAgendamento(agendamento);
    }

    @GetMapping("/listar-todos")
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }
    
    @GetMapping("/listar-por-status")
    public List<Agendamento> listarAgendamentosPorStatus(@RequestParam String status) {
        return agendamentoService.listarAgendamentosPorStatus(StatusAgendamento.valueOf(status));
    }

    
     @GetMapping("/listar-por-cliente/{clienteId}")
    public List<Agendamento> listarAgendamentosPorCliente(@PathVariable Long clienteId) {
        return agendamentoService.listarAgendamentosPorCliente(clienteId);
    }

    @PutMapping("/concluir/{agendamentoId}")
    public Agendamento concluirAgendamento(@PathVariable Long agendamentoId) {
        return agendamentoService.concluirAgendamento(agendamentoId);
    }

    @PutMapping("/cancelar/{agendamentoId}")
    public Agendamento cancelarAgendamento(@PathVariable Long agendamentoId) {
        return agendamentoService.cancelarAgendamento(agendamentoId);
    }
    
    @PutMapping("/editar/{agendamentoId}")
    public Agendamento editarAgendamento(@PathVariable Long agendamentoId, @RequestBody Agendamento agendamentoAtualizado) {
        return agendamentoService.editarAgendamento(agendamentoId, agendamentoAtualizado);
    }

    @GetMapping("/buscar/{agendamentoId}")
    public Agendamento buscarAgendamentoPorId(@PathVariable Long agendamentoId) {
        return agendamentoService.buscarAgendamentoPorId(agendamentoId);
    }

     @DeleteMapping("/deletar/{agendamentoId}")
    public void deletarAgendamento(@PathVariable Long agendamentoId) {
        agendamentoService.deletarAgendamento(agendamentoId);
    }

     @GetMapping("/listar-por-data-inicio")
    public List<Agendamento> listarAgendamentosPorDataInicio(@RequestParam String dataInicio) {
        return agendamentoService.listarAgendamentosPorDataInicio(java.time.LocalDateTime.parse(dataInicio));
    }
    

    @GetMapping("/buscar-ultimo-agendamento-cliente/{clienteid}")
    public Agendamento buscarUltimoAgendamentoDoCliente(@RequestParam Long clienteId) {
        return agendamentoService.buscarUltimoAgendamentoDoCliente(clienteId);
    }

}
