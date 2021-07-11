package br.com.crud.saladereuniao.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "sala_de_reuniao")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column (name = "data")
    private String data;
    @Column (name = "inicio_do_horario")
    private String horarioInicio;
    @Column (name = "fim_do_horaio")
    private String horairioFinal;

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", horarioInicio='" + horarioInicio + '\'' +
                ", horairioFinal='" + horairioFinal + '\'' +
                '}';
    }
}
