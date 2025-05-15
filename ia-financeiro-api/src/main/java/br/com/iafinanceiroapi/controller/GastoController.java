package br.com.iafinanceiroapi.controller;

import br.com.iafinanceiroapi.request.GastoRequest;
import br.com.iafinanceiroapi.service.GastoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(name = "/api/gasto")
public class GastoController {

    private GastoService gastoService;

    @PostMapping
    public Mono<ResponseEntity<Void>> create(@RequestBody GastoRequest gastoRequest) {
        return gastoService.create(gastoRequest)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }
}
