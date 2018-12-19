package com.yanghui.study.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

@Component
public class PreGatewayFilterFactory extends AbstractGatewayFilterFactory<PreGatewayFilterFactory.Config> {

	public PreGatewayFilterFactory() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(PreGatewayFilterFactory.Config config) {
		// grab configuration from Config object
		return (exchange, chain) -> {
//            if (!config.isEnabled()) {
//                return chain.filter(exchange);
//            }
            //If you want to build a "pre" filter you need to manipulate the
            //request before calling change.filter
            //ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
            //use builder to manipulate the request
            Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
            String uriPrefix = route.getUri().toString();
            ServerHttpRequest req = exchange.getRequest();
            String raw = req.getURI().getRawPath();
            URI uri = UriComponentsBuilder.fromHttpUrl(uriPrefix+raw).build().toUri();
            ServerHttpRequest request = exchange.getRequest().mutate().uri(uri).build();
            Route newRoute = Route.async()
            .asyncPredicate(route.getPredicate())
            .filters(route.getFilters())
            .id(route.getId())
            .order(route.getOrder())
            .uri(uri)
            .build();
            exchange.getAttributes().put(GATEWAY_ROUTE_ATTR, newRoute);
            return chain.filter(exchange.mutate().request(request).build());
		};
	}

	public static class Config {
        //Put the configuration properties for your filter here
        private boolean enabled;

        public Config() {}

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
	}

}