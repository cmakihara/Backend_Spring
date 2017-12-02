package br.casa.agendaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.properties.PropertyMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casa.agendaapi.model.Usuario;
import br.casa.agendaapi.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
        
    }
    
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuarioById
    			(@PathVariable(value = "id") Long usuarioId) {
        Usuario usuario = usuarioRepository.findOne(usuarioId);
        
        if(usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(usuario);
        
    }
    
    @PostMapping("/usuario")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    
    
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable(value = "id") Long UsuarioId) {
    	usuarioRepository.delete(UsuarioId);
    	return null;
    }
    
    @PutMapping("/usuario/{id}")
    public Usuario putUsuario(@PathVariable(value = "id") Long UsuarioId,@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }



	
	
	
}
