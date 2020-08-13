package com.prenetics.common.utility.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import com.prenetics.common.utility.Constants;

import java.io.IOException;
import java.io.InputStream;

public class HTTPRequester {

	private final static Logger logger = Logger.getLogger(HTTPRequester.class);

	private String url;

	public HTTPRequester(String url) {
		this.url = url;
	}

	/**
	 * Request to a url and return a raw InputStream
	 *
	 * @return Raw InputStream object which you need to process to get the content you want yourself,
	 * whether it is a text file, content key file, Excel file, etc
	 */
	public InputStream request() {
		InputStream result = null;
		try {
			logger.info("request :: [" + url + "]");
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(Constants.Timeout.HTTP_REQUEST).build();
			HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
			HttpResponse response = client.execute(new HttpGet(url));
			result = response.getEntity().getContent();
		} catch (IOException e) {
			logger.error("request :: " + e.getClass().getSimpleName() + " occurred");
			e.printStackTrace();
		}
		return result;
	}
}
