package br.com.iafinanceiroapi.controller;

import br.com.iafinanceiroapi.repository.GastoRepository;
import br.com.iafinanceiroapi.service.IAservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/analise")
public class AnaliseController {

    private final GastoRepository gastoRepo;
    private final IAservice IAservice;

    public AnaliseController(GastoRepository gastoRepo, IAservice IAservice) {
        this.gastoRepo = gastoRepo;
        this.IAservice = IAservice;
    }

    @PostMapping("/information")
   public Mono<ResponseEntity<String>> getInfo(@RequestParam String message) {
    LocalDateTime inicio = LocalDateTime.of(LocalDate.now().getYear(), 3, 1, 0, 0);
    LocalDateTime fim = LocalDateTime.now();

    return gastoRepo.findByDataBetween(inicio, fim)
            .collectList()
            .flatMap(gastos -> {
                String historico = gastos.stream()
                        .map(g -> String.format("Categoria: %s | R$ %.2f | Mês: %s",
                                g.getCategoria() ,
                                g.getValor(),
                                g.getData()))
                        .collect(Collectors.joining("\n"));

                return IAservice.gerarResposta(message, historico)
                        .map(ResponseEntity::ok)
                        .onErrorResume(ex ->
                            Mono.just(ResponseEntity.ok("Erro ao chamar a IA: " + ex.getMessage()))
                        );
            });
}



}
