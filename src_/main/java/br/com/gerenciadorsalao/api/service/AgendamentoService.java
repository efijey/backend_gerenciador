package br.com.gerenciadorsalao.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciadorsalao.api.entity.Agendamento;
import br.com.gerenciadorsalao.api.entity.Cliente;
import br.com.gerenciadorsalao.api.enums.StatusAgendamento;
import br.com.gerenciadorsalao.api.repository.AgendamentoRepository;
import br.com.gerenciadorsalao.api.repository.ClienteRepository;
import java.util.Optional;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Agendamento criarAgendamento(Agendamento agendamento){
        
        Long clienteId = agendamento.getCliente().getId();
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);

        if (clienteOptional.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }
            agendamento.setCliente(clienteOptional.get());
            agendamento.setStatus(StatusAgendamento.ABERTO);
        
        return agendamentoRepository.save(agendamento);
    }

    public Agendamento concluirAgendamento(Long agendamentoId){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamentoId);

        if (agendamentoOptional.isEmpty()){
            throw new RuntimeException("Agendamento não encontrado");
        }

        Agendamento agendamento = agendamentoOptional.get();
        agendamento.setStatus(StatusAgendamento.CONCLUIDO);

        return agendamentoRepository.save(agendamento);
    }

    public Agendamento cancelarAgendamento(Long agendamentoId){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamentoId);

        if (agendamentoOptional.isEmpty()){
            throw new RuntimeException("Agendamento não encontrado");
        }

        Agendamento agendamento = agendamentoOptional.get();
        agendamento.setStatus(StatusAgendamento.CANCELADO);

        return agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarAgendamentoPorId(Long agendamentoId){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamentoId);

        if (agendamentoOptional.isEmpty()){
            throw new RuntimeException("Agendamento não encontrado");
        }

        return agendamentoOptional.get();
    }

    public void deletarAgendamento(Long agendamentoId){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamentoId);

        if (agendamentoOptional.isEmpty()){
            throw new RuntimeException("Agendamento não encontrado");
        }

        agendamentoRepository.deleteById(agendamentoId);
    }

    public Agendamento editarAgendamento(Long agendamentoId, Agendamento agendamentoAtualizado){
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(agendamentoId);

        if (agendamentoOptional.isEmpty()){
            throw new RuntimeException("Agendamento não encontrado");
        }

        Agendamento agendamento = agendamentoOptional.get();
        agendamento.setDataInicio(agendamentoAtualizado.getDataInicio());
        agendamento.setDataFim(agendamentoAtualizado.getDataFim());
        agendamento.setServico(agendamentoAtualizado.getServico());
        agendamento.setValor(agendamentoAtualizado.getValor());

        return agendamentoRepository.save(agendamento);
    }

    public List<Agendamento> listarAgendamentosPorStatus(StatusAgendamento status){
        return agendamentoRepository.findByStatus(status);
    }

    public List<Agendamento> listarAgendamentosPorCliente(Long clienteId){
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);

        if (clienteOptional.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }

        return agendamentoRepository.findByCliente(clienteOptional.get());
    }

    public List<Agendamento> listarAgendamentosPorDataInicio(LocalDateTime dataInicio){
        return agendamentoRepository.findByDataInicio(dataInicio);
    }

    public List<Agendamento> listarAgendamentos(){
        return agendamentoRepository.findAll();
    }
}
