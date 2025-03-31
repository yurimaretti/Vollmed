package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import med.voll.api.services.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedicos(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medico(dados));
    }

    //Listagem paginada, porém sem os metadados da consulta (numeroPagina, tamanhoPagina, totalResultados e totalPaginas)
    //Por padrão retorna uma página de tamanho 10 e ordena pela propriedade "nome", mas pode ser alterado nos Query Params
    @GetMapping
    public List<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return repository.findAll(pageable).stream().map(DadosListagemMedico::new).toList();
    }

    //Listagem paginada, com a mesma funcionalidade de paginação acima, mas também com retorno personalizado de paginação (objetos DTO: resultado e paginacao)
    //Por padrão retorna uma página de tamanho 10 e ordena pela propriedade "nome", mas pode ser alterado nos Query Params
    @GetMapping("paginando")
    public DadosPaginacaoGeneric<DadosListagemMedico> listarPaginando(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        Page<DadosListagemMedico> page = repository.findAll(paginacao).map(DadosListagemMedico::new);

        return new DadosPaginacaoGeneric<>(page);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
