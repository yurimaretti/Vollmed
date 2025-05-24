package med.voll.api.exception;

import org.springframework.validation.BindingResult;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
