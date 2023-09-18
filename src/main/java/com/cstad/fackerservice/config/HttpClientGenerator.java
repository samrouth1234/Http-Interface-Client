package com.cstad.fackerservice.config;


import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class HttpClientGenerator {

    // create webclient builder
    private static WebClient.Builder builder = WebClient.builder();

    // create web client
    private static WebClient webClient = builder.build();


    // create proxy using webclient adapter for client webclient and build proxy using HttpServiceProxyFactory builder
    private static HttpServiceProxyFactory proxy = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient))
            .build();

    // S = Service
    // class genera using dynamic
    public static <S> S createClientService(Class<S> clientService){
        return proxy.createClient(clientService);
    }

}
