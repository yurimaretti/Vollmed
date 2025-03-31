package med.voll.api.exception;

import java.time.LocalDateTime;

public record Erro404DTO(
        LocalDateTime timestamp,
        int status,
        String erro,
        String path
) {}

