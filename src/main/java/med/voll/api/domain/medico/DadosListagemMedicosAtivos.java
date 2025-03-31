package med.voll.api.domain.medico;

public record DadosListagemMedicosAtivos(
        Long id,
        String nome,
        String crm,
        String telefone,
        String email,
        Especialidade especialidade
) {

    public DadosListagemMedicosAtivos(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getTelefone(), medico.getEmail(), medico.getEspecialidade());
    }

}
