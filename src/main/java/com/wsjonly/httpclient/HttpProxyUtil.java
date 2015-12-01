package com.wsjonly.httpclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.util.EntityUtils;

public class HttpProxyUtil {

	private static CloseableHttpClient getClient() {
		// TODO Auto-generated method stub
		HttpHost proxy = new HttpHost("b.qypac.net", 34027);
		DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
		return HttpClients.custom().setRoutePlanner(routePlanner).build();
	}

	public static String getDirect(String url, Map<String, String> params) {

		CloseableHttpClient httpClient = getClient();
		try {

			StringBuilder query = new StringBuilder();
			Iterator<String> iterator = params.keySet().iterator();
			while (iterator.hasNext()) {
				if (query.length() > 0)
					query.append("&");
				else
					query.append("?");

				String key = iterator.next();
				query.append(key);
				query.append("=");
				query.append(URLEncoder.encode(params.get(key), "utf-8"));

				System.out.println(query.toString());
			}

			HttpGet httpGet = new HttpGet(url + query);
			httpGet.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");

			RequestConfig config = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
			httpGet.setConfig(config);

			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				@Override
				public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					// TODO Auto-generated method stub

					HttpEntity entity = response.getEntity();

					return EntityUtils.toString(entity, "utf-8");
				}

			};

			String responseBody = httpClient.execute(httpGet, responseHandler);

			return responseBody;

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("http connection closed");
		}

		// System.out.println(query.toString());
		return null;
	}

	public static void main(String[] args) {
		Map params = new HashMap<String, String>();
		// map.put("p1", "1");
		// map.put("p2", "2");
		String result = HttpProxyUtil.getDirect("http://www.brendangregg.com/linuxperf.html", params);
		System.out.println(result);

	}
}
