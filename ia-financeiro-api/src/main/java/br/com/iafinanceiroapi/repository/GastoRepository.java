package br.com.iafinanceiroapi.repository;

import br.com.iafinanceiroapi.model.Gasto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface GastoRepository extends ReactiveCrudRepository<Gasto, Long> {
    Flux<Gasto> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}