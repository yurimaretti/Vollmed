package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import med.voll.api.services.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMedicos(@RequestBody @Valid DadosCadastroMedicos dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    //Listagem paginada, porém sem os metadados da consulta (numeroPagina, tamanhoPagina, totalResultados e totalPaginas)
    //Por padrão retorna uma página de tamanho 10 e ordena pela propriedade "nome", mas pode ser alterado nos Query Params
    @GetMapping
    public ResponseEntity<List<DadosListagemTodosMedicos>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var resposta = repository.findAll(paginacao).stream().map(DadosListagemTodosMedicos::new).toList();
        return ResponseEntity.ok(resposta);
    }

    //Listagem paginada, com a mesma funcionalidade de paginação acima, mas também com retorno personalizado de paginação (objetos DTO: resultado e paginacao)
    //Por padrão retorna uma página de tamanho 10 e ordena pela propriedade "nome", mas pode ser alterado nos Query Params
    @GetMapping("paginando")
    public ResponseEntity<DadosPaginacaoGeneric<DadosListagemMedicosAtivos>> listarPaginando(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        Page<DadosListagemMedicosAtivos> page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicosAtivos::new);
        return ResponseEntity.ok(new DadosPaginacaoGeneric<>(page));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping("inativar/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.ativar();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
