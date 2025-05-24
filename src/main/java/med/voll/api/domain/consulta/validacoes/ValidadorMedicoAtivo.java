package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.exception.ValidacaoException;
import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorMedicoAtivo {
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        //Como médico é opcional, se não for informado médico ele é incluído aleatoriamente pelo sistema
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("A consulta não pode ser agendada com o médico solicitado");
        }
    }
}
