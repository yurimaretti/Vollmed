package med.voll.api.medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String crm,
        String telefone,
        String email,
        Especialidade especialidade
) {

    public DadosListagemMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getTelefone(), medico.getEmail(), medico.getEspecialidade());
    }

}
