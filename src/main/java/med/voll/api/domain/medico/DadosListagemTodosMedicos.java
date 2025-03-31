package med.voll.api.domain.medico;

public record DadosListagemTodosMedicos(
        Long id,
        String nome,
        String crm,
        String telefone,
        String email,
        Especialidade especialidade,
        Boolean ativo
) {

    public DadosListagemTodosMedicos(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getTelefone(), medico.getEmail(), medico.getEspecialidade(), medico.getAtivo());
    }

}
