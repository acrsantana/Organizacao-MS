package br.com.acrtech.planningpoker.organizacoes.controller;

import br.com.acrtech.planningpoker.organizacoes.exception.ErroAoRecuperarOrganizacoesException;
import br.com.acrtech.planningpoker.organizacoes.exception.ErroAoSalvarOrganizacaoException;
import br.com.acrtech.planningpoker.organizacoes.exception.OrganizacaoNaoEncontradaException;
import br.com.acrtech.planningpoker.organizacoes.model.Organizacao;
import br.com.acrtech.planningpoker.organizacoes.service.OrganizacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class OrganizacaoController {

    private final OrganizacaoService organizacaoService;

    public OrganizacaoController(OrganizacaoService organizacaoService) {
        this.organizacaoService = organizacaoService;
    }

    @PostMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<Organizacao> save(@RequestBody Organizacao organizacao){
        try {
            return ResponseEntity.ok(organizacaoService.save(organizacao));
        } catch (ErroAoSalvarOrganizacaoException e) {
            throw new ErroAoSalvarOrganizacaoException(e.getMessage());
        }
    }

    @GetMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<Organizacao>> findAll(){
        try {
            return ResponseEntity.ok(organizacaoService.findAll());
        } catch (ErroAoRecuperarOrganizacoesException e) {
            throw new ErroAoRecuperarOrganizacoesException(e.getMessage());
        }

    }

    @GetMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Organizacao> findById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(organizacaoService.findById(id));
        } catch (OrganizacaoNaoEncontradaException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Organizacao> update(
        @RequestBody Organizacao organizacao,
        @PathVariable Integer id
    ){
        try {
            return ResponseEntity.ok(organizacaoService.update(organizacao));
        } catch (OrganizacaoNaoEncontradaException e) {
            throw new OrganizacaoNaoEncontradaException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Integer id){
        organizacaoService.deleteById(id);
    }
}
