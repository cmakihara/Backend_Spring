package br.casa.agendaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casa.agendaapi.model.Contato;
import br.casa.agendaapi.repository.ContatoRepository;

@RestController
@RequestMapping("/api")
public class ContatoController {

	@Autowired
    ContatoRepository contatoRepository;

    @GetMapping("/agenda")
    public List<Contato> getAllContatos() {
        return contatoRepository.findAll();
    }
    
    
    @GetMapping("/agenda/{id}")
    public ResponseEntity<Contato> getContatoById
    			(@PathVariable(value = "id") Long contatoId) {
        Contato contato = contatoRepository.findOne(contatoId);
        if(contato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(contato);
    }
    
    @PostMapping("/agenda")
    public Contato createContato(@Valid @RequestBody Contato contato) {
        return contatoRepository.save(contato);
    }
    
    
    @DeleteMapping("/agenda/{id}")
    public ResponseEntity<Contato> deleteContato(@PathVariable(value = "id") Long contatoId) {
    	contatoRepository.delete(contatoId);
    	return null;
    }




	
	
	
}
