package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco endereco) {
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.uf = endereco.uf();
        this.cidade = endereco.cidade();
        this.complemento = endereco.complemento();
        this.logradouro = endereco.logradouro();
        this.numero = endereco.numero();
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if (endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if (endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if (endereco.uf() != null){
            this.uf = endereco.uf();
        }
        if (endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if (endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
        if (endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if (endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if (endereco.numero() != null){
            this.numero = endereco.numero();
        }
    }
}
