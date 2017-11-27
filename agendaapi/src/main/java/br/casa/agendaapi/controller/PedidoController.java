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
    PedidoRepository PedidoRepository;

    @GetMapping("/pedido")
    public List<Pedido> getAllPedidos() {
        return PedidoRepository.findAll();
    }
    
    
    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> getPedidoById
    			(@PathVariable(value = "id_pedido") Long PedidoId) {
        Pedido Pedido = PedidoRepository.findOne(PedidoId);
        
        if(Pedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(Pedido);
        
    }
    
    @PostMapping("/pedido")
    public Pedido createPedido(@Valid @RequestBody Pedido Pedido) {
        return PedidoRepository.save(Pedido);
    }
    
    
    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<Pedido> deletePedido(@PathVariable(value = "id_pedido") Long PedidoId) {
    	PedidoRepository.delete(PedidoId);
    	return null;
    }
    @PutMapping("/pedido/{id}")
    public Pedido putPedido(@PathVariable(value = "id_pedido") Long PedidoId,@Valid @RequestBody Pedido Pedido) {
        return PedidoRepository.save(Pedido);
    }
    
	
}
