package br.com.crud.saladereuniao.exception;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ErrorDetails {

    private Date timestamp;
    private String mensagem;
    private String detalhe;
}
