package br.casa.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.casa.agendaapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
