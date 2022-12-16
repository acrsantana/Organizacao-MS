package br.com.acrtech.planningpoker.organizacoes.service;

import br.com.acrtech.planningpoker.organizacoes.exception.ErroAoRecuperarOrganizacoesException;
import br.com.acrtech.planningpoker.organizacoes.exception.ErroAoSalvarOrganizacaoException;
import br.com.acrtech.planningpoker.organizacoes.exception.OrganizacaoNaoEncontradaException;
import br.com.acrtech.planningpoker.organizacoes.model.Organizacao;
import br.com.acrtech.planningpoker.organizacoes.repository.OrganizacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrganizacaoService {

    private final OrganizacaoRepository organizacaoRepository;

    public OrganizacaoService(OrganizacaoRepository organizacaoRepository) {
        this.organizacaoRepository = organizacaoRepository;
    }

    public Organizacao save(Organizacao organizacao){
        log.info("Salvando a organização {}", organizacao.getNome());
        try {
            return organizacaoRepository.save(organizacao);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar organização {}", organizacao.getNome());
            throw new ErroAoSalvarOrganizacaoException("Erro ao tentar salvar organização");
        }
    }

    public Organizacao findById(Integer id) {
        log.info("Buscando organização pelo id {}", id);
        Optional<Organizacao> optionalOrganizacao = organizacaoRepository.findById(id);
        if (optionalOrganizacao.isEmpty()){
            log.error("A organização com o id {} não foi localizada", id);
            throw new OrganizacaoNaoEncontradaException("A organização não foi localizada");
        }
        return optionalOrganizacao.get();
    }

    public List<Organizacao> findAll(){
        log.info("Buscando todas as organizações");
        try {
            return organizacaoRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ErroAoRecuperarOrganizacoesException("Erro ao tentar recuperar as organizações");
        }
    }
    @Transactional
    public Organizacao update(Organizacao org) {
        log.info("Atualizando o nome da organização com id {} para {}", org.getId(), org.getNome());
        var organizacao = findById(org.getId());
        organizacao.setNome(org.getNome());
        return organizacao;
    }

    public void deleteById(Integer id) {
        log.info("Deletando a organização com o id {}", id);
        organizacaoRepository.deleteById(id);
    }
}
