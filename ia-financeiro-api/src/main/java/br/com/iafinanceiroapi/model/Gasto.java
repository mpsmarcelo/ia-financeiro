package br.com.iafinanceiroapi.model;

import br.com.iafinanceiroapi.enums.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table("gastos")
@Getter
@Setter
public class Gasto {
    @Id
    private Long id;
    private BigDecimal valor;
    private String descricao;
    private LocalDateTime data;
    private Categoria categoria;
}