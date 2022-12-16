package br.com.acrtech.planningpoker.organizacoes.repository;

import br.com.acrtech.planningpoker.organizacoes.model.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Integer> {
}
