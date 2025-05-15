package br.com.iafinanceiroapi.service;


import br.com.iafinanceiroapi.model.Gasto;
import br.com.iafinanceiroapi.repository.GastoRepository;
import br.com.iafinanceiroapi.request.GastoRequest;
import reactor.core.publisher.Mono;

public class GastoServiceImpl implements GastoService {

    private final GastoRepository gastoRepository;

    GastoServiceImpl(GastoRepository gastoRepository) {
        this.gastoRepository = gastoRepository;
    }

    @Override
    public Mono<Gasto> create(GastoRequest gastoRequest) {
        return gastoRepository.save(gastoRequest.toEntity());
    }


}
