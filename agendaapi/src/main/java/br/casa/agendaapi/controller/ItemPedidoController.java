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

import br.casa.agendaapi.model.ItemPedido;
import br.casa.agendaapi.model.Pedido;
import br.casa.agendaapi.model.Usuario;
import br.casa.agendaapi.repository.ItemPedidoRepository;

@RestController
@RequestMapping("/api")
public class ItemPedidoController {
	
	@Autowired
    ItemPedidoRepository itemPedidoRepository;
	
    @PostMapping("/itempedido")
    public ItemPedido lala(@Valid @RequestBody ItemPedido item) {
        return itemPedidoRepository.save(item);
    }
    @GetMapping("/itempedido")
    public List<ItemPedido> getAllItemPedidos() {
        return itemPedidoRepository.findAll();
    }
    @GetMapping("/itempedido/{id}")
    public ResponseEntity<ItemPedido> getItemPedidoById
    			(@PathVariable(value = "id") Long itempedidoId) {
        ItemPedido itempedido = itemPedidoRepository.findOne(itempedidoId);
        
        if(itempedido == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(itempedido);
        
    }
    @DeleteMapping("/itempedido/{id}")
    public ResponseEntity<ItemPedido> deleteItemPedido(@PathVariable(value = "id") Long itempedidoId) {
    	itemPedidoRepository.delete(itempedidoId);
    	return null;
    }

}
