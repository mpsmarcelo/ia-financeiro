package br.com.iafinanceiroapi.request;

import br.com.iafinanceiroapi.enums.Categoria;
import br.com.iafinanceiroapi.model.Gasto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
@Data
public class GastoRequest {

    private Long id;
    private BigDecimal valor;
    private String descricao;
    private LocalDateTime data;
    private Categoria categoria;

       public Gasto toEntity() {
        Gasto gasto = new Gasto();
        gasto.setId(this.id);
        gasto.setData(this.data);
        gasto.setValor(this.valor);
        gasto.setDescricao(this.descricao);
        gasto.setCategoria(this.categoria);
        return gasto;
    }

}
