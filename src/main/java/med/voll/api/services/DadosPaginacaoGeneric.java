package med.voll.api.services;

import org.springframework.data.domain.Page;

import java.util.List;

public record DadosPaginacaoGeneric<T>(
        List<T> resultado,
        PaginacaoInfoGeneric paginacao
) {
    public DadosPaginacaoGeneric(Page<T> page) {
        this(page.getContent(), new PaginacaoInfoGeneric(page));
    }
}
