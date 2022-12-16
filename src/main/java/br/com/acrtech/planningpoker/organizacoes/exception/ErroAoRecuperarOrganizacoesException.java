package br.com.acrtech.planningpoker.organizacoes.exception;

public class ErroAoRecuperarOrganizacoesException extends RuntimeException {
    public ErroAoRecuperarOrganizacoesException(String message) {
        super(message);
    }

    public ErroAoRecuperarOrganizacoesException(String message, Throwable cause) {
        super(message, cause);
    }
}
