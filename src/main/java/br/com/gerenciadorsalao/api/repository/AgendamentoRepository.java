package br.com.gerenciadorsalao.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciadorsalao.api.entity.Agendamento;
import br.com.gerenciadorsalao.api.entity.Cliente;
import br.com.gerenciadorsalao.api.enums.StatusAgendamento;
import java.util.List;
import java.time.LocalDateTime;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

    List<Agendamento> findByStatus(StatusAgendamento status);

    List<Agendamento> findByCliente(Cliente cliente);

    List<Agendamento> findByDataInicio(LocalDateTime dataInicio);
    
}
