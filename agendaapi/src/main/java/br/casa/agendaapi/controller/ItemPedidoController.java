package br.casa.agendaapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casa.agendaapi.model.ItemPedido;
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

}
