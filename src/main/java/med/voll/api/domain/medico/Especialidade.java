package med.voll.api.domain.medico;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Especialidade {
    ORTOPEDIA,
    CARDIOLOGIA,
    GINECOLOGIA,
    DERMATOLOGIA,
    UROLOGIA;

    @JsonCreator
    public static Especialidade fromString(String especialidade) {
        if (especialidade != null) {
            return Especialidade.valueOf(especialidade.toUpperCase());
        }
        return null;
    }
}
