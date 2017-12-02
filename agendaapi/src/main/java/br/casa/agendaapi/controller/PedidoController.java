package br.casa.agendaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casa.agendaapi.model.Pedido;
import br.casa.agendaapi.repository.PedidoRepository;

@RestController
@RequestMapping("/api")
public class PedidoController {

	@Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/pedido")
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }
    
    
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> getPedidoById
    			(@PathVariable(value = "id") Long pedidoId) {
        Pedido pedido = pedidoRepository.findOne(pedidoId);
        
        if(pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(pedido);
        
    }
    
    @PostMapping("/pedido")
    public Pedido createPedido(@Valid @RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    
    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable(value = "id") Long pedidoId) {
    	pedidoRepository.delete(pedidoId);
    	return null;
    }
    @PutMapping("/pedido/{id}")
    public Pedido putPedido(@PathVariable(value = "id") Long pedidoId,@Valid @RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
	
}
