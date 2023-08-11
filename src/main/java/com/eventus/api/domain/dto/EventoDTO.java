package com.eventus.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude
public class EventoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 113123123L;

    private String noEvento;
    private String dsEvento;
    @JsonFormat()
    private LocalDateTime dtEvento;

}
