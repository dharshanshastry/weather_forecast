package com.org.application;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.org.constants.CacheConstants;

@Configuration
@ComponentScan("com.org.*")
public class WeatherForeCastConfiguration {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherForeCastConfiguration.class);
	

	
	@Autowired
	CloseableHttpClient httpClient;

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
		return restTemplate;
	}

	@Bean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory 
		= new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setHttpClient(httpClient);
		return clientHttpRequestFactory;
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 5000;
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout)
				.build();
		CloseableHttpClient client = HttpClientBuilder
				.create()
				.setDefaultRequestConfig(config)
				.build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}

	@Bean(name="httpClient")
	public CloseableHttpClient httpClient() {
		return HttpClientBuilder.create().build();
	}
	
	@Bean
	public CacheManager cacheManager() {
		final ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(CacheConstants.WEATHER_CACHE);

		return cacheManager;
	}

	
	@CacheEvict(allEntries = true, value = {CacheConstants.WEATHER_CACHE})
	@Scheduled(fixedDelay = 60 * 60 *10,  initialDelay = 500)
	public void reportCacheEvict() {
		LOGGER.debug("Evicting weather caches");
	}

}
