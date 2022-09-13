package io.github.jaconunes.vendas.exception;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("A Senha é inválida!");
    }
}
