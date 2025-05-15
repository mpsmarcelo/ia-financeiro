package br.com.iafinanceiroapi.service;

import br.com.iafinanceiroapi.request.OpenRouterRequest;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class IAservice {

    private final WebClient client;

    public IAservice(WebClient openRouterClient) {
        this.client = openRouterClient;
    }

    public Mono<String> gerarResposta(String pergunta, String contexto) {
        OpenRouterRequest requestBody = new OpenRouterRequest(
                "deepseek/deepseek-chat:free",
                List.of(
                        new OpenRouterRequest.Message("system", "Você é um assistente financeiro."),
                        new OpenRouterRequest.Message("user", contexto + "\n" + pergunta)
                )
        );

        return client.post()
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .map(json -> json.get("choices").get(0).get("message").get("content").asText())
                .onErrorResume(ex -> {
                    ex.printStackTrace(); // debug real
                    return Mono.just("Erro ao chamar a IA: " + ex.getMessage());
                });
    }


}
