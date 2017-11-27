package br.casa.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casa.agendaapi.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
