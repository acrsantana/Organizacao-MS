package br.com.acrtech.planningpoker.organizacoes.model;

import br.com.acrtech.planningpoker.organizacoes.dto.OrganizacaoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "organizacoes")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Organizacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nome;

    public Organizacao(OrganizacaoDto organizacaoDto) {
        BeanUtils.copyProperties(organizacaoDto, this);
    }
}
