package med.voll.api.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErroRegraDeNegocioDTO(
        LocalDateTime timestamp,
        int status,
        String erro,
        String path,
        String mensagem
) {

}
