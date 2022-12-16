package br.com.acrtech.planningpoker.organizacoes.exception;

public class ErroAoSalvarOrganizacaoException extends RuntimeException {
    public ErroAoSalvarOrganizacaoException(String message) {
        super(message);
    }

    public ErroAoSalvarOrganizacaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
