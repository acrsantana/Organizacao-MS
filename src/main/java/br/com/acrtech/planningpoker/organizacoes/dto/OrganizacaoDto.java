package br.com.acrtech.planningpoker.organizacoes.dto;

import br.com.acrtech.planningpoker.organizacoes.model.Organizacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class OrganizacaoDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @NotBlank(message = "Nome da organização não pode ser nulo ou branco")
    @Size(min = 2, max = 20, message = "Nome da organização precisa ter entre 2 e 20 caracteres")
    private String nome;

    public OrganizacaoDto(Organizacao organizacao) {
        BeanUtils.copyProperties(organizacao, this);
    }
}
