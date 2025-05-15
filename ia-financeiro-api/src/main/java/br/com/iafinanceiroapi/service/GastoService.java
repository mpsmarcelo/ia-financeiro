package br.com.iafinanceiroapi.service;

import br.com.iafinanceiroapi.model.Gasto;
import br.com.iafinanceiroapi.request.GastoRequest;
import reactor.core.publisher.Mono;

public interface GastoService {

     Mono<Gasto> create(GastoRequest gasto);
}
