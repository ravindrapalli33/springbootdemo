package com.rav.springbootdemo.config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;
import reactor.netty.tcp.TcpClient;

@Configuration
public class CustomWebClientConfig {

	@Value("${novelcovid19.base_url}") private String novelCovidBaseUrl;

	@Value("${novelcovid19.cookie}") private String novelCovidCookie;

	@Bean
	public WebClient novelCovidWebClient() {
		ConnectionProvider provider = ConnectionProvider.builder("fixed")
				.maxConnections(200)
				.pendingAcquireTimeout(Duration.ofMillis(30000))
				.maxIdleTime(Duration.ofMillis(60))
				.build();

		TcpClient tcpClient = TcpClient.create(provider)
				.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 60000)
				.doOnConnected(connection ->
					connection
						.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
						.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS))
				);

	    return WebClient.builder()
	    		.baseUrl(novelCovidBaseUrl)
	    		.clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
	    		.defaultCookie(HttpHeaders.COOKIE, novelCovidCookie)
	    		.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	    		.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
	    		.build();
	}

}
