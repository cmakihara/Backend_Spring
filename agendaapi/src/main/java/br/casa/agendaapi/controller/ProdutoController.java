package br.casa.agendaapi.controller;

import java.util.ArrayList;
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

import br.casa.agendaapi.model.Produto;
import br.casa.agendaapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
    ProdutoRepository ProdutoRepository;

    @GetMapping("/produto")
    public List<Produto> getAllProdutos() {
        return ProdutoRepository.findAll();
    }
    
    
    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> getProdutoById
    			(@PathVariable(value = "id") Long ProdutoId) {
    	Produto Produto = ProdutoRepository.findOne(ProdutoId);
        if(Produto == null) {
            return ResponseEntity.notFound().build();
        }
        System.out.println(ResponseEntity.ok().body(Produto));
        return ResponseEntity.ok().body(Produto);
    }
    
    @PostMapping("/produto")
    public Produto createProduto(@Valid @RequestBody Produto Produto) {
        return ProdutoRepository.save(Produto);
    }
    
    
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Produto> deleteProduto(@PathVariable(value = "id") Long ProdutoId) {
    	ProdutoRepository.delete(ProdutoId);
    	return null;
    }
    @PutMapping("/produto/{id}")
    public Produto putProduto(@PathVariable(value = "id") Long ProdutoId,@Valid @RequestBody Produto Produto) {
        return ProdutoRepository.save(Produto);
    }




	
	
	
}
