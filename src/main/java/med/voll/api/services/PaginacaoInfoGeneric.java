package med.voll.api.services;

import org.springframework.data.domain.Page;

public record PaginacaoInfoGeneric(
        int numeroPagina,
        int tamanhoPagina,
        long totalResultados,
        int totalPaginas
) {
    public PaginacaoInfoGeneric(Page<?> page) {
        this(page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
