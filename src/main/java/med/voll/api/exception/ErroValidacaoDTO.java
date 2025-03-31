package med.voll.api.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ErroValidacaoDTO(
        LocalDateTime timestamp,
        int status,
        String erro,
        String path,
        Map<String, String> campos
) {}

