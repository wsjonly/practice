package com.wsjonly.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {
	private static Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
    private static final int sTimeout = 30000;
    private static final int conTimeout = 5000;

	private static CloseableHttpClient getClient() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		return httpclient;
	}

	/**
	 * ���Զ��Բ������UrlEncode
	 * @param url
	 * @param params
	 * @return
	 */
	public static String post(String url, Map<String, String> params) {
		CloseableHttpClient httpclient = getClient();
		try {
			HttpPost httppost = new HttpPost(url);
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(sTimeout).setConnectTimeout(conTimeout).build();
            httppost.setConfig(requestConfig);
			
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}

			try {
				log.debug("set utf-8 form entity to httppost");
				httppost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						String charset = null;
						if(entity!=null){
							ContentType ct = ContentType.getOrDefault(entity);
							charset = ct.getCharset() == null ? "ISO-8859-1":ct.getCharset().toString();
						}
						return entity != null ? EntityUtils.toString(entity,charset) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httppost, responseHandler);
			return responseBody;
		} catch (ClientProtocolException e) {
			log.error("call url:"+url+" error.",e);
		} catch (Exception e) {
			log.error("call url:"+url+" error.",e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "error";
	}
	
	public static String postJson(String url, JSONObject params) {
        CloseableHttpClient httpclient = getClient();
        try {
            HttpPost httppost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(sTimeout).setConnectTimeout(conTimeout).build();
            httppost.setConfig(requestConfig);
            httppost.setHeader("Content-Encoding", "charset=utf-8");
            httppost.setHeader("Content-Type", "text/html;charset=utf-8");
            httppost.setHeader("Connection", "close");

            try {
                StringEntity reqEntity = new StringEntity(params.toString(),HTTP.UTF_8);
                log.debug("set utf-8 form entity to httppost");
                httppost.setEntity(reqEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        String charset = null;
                        if(entity!=null){
                            ContentType ct = ContentType.getOrDefault(entity);
                            charset = ct.getCharset() == null ? "ISO-8859-1":ct.getCharset().toString();
                        }
                        return entity != null ? EntityUtils.toString(entity,charset) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httppost, responseHandler);
            return responseBody;
        } catch (ClientProtocolException e) {
            log.error("call url:"+url+" error.",e);
        } catch (Exception e) {
            log.error("call url:"+url+" error.",e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "error";
    }
	
    public static String putJson(String url, JSONObject params) {
        CloseableHttpClient httpclient = getClient();
        try {
            HttpPut httpput = new HttpPut(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(sTimeout).setConnectTimeout(conTimeout).build();
            httpput.setConfig(requestConfig);
            httpput.setHeader("Content-Encoding", "charset=utf-8");
            httpput.setHeader("Content-Type", "text/html;charset=utf-8");
            httpput.setHeader("Connection", "close");

            try {
                StringEntity reqEntity = new StringEntity(params.toString(),HTTP.UTF_8);
                log.debug("set utf-8 form entity to httppost");
                httpput.setEntity(reqEntity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                public String handleResponse(final HttpResponse response)
                        throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        String charset = null;
                        if(entity!=null){
                            ContentType ct = ContentType.getOrDefault(entity);
                            charset = ct.getCharset() == null ? "ISO-8859-1":ct.getCharset().toString();
                        }
                        return entity != null ? EntityUtils.toString(entity,charset) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }
            };
            String responseBody = httpclient.execute(httpput, responseHandler);
            return responseBody;
        } catch (ClientProtocolException e) {
            log.error("call url:"+url+" error.",e);
        } catch (Exception e) {
            log.error("call url:"+url+" error.",e);
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "error";
    }	
	
	/**
	 * ���Զ��Բ������UrlEncode
	 * @param url
	 * @param params
	 * @return
	 */
	public static String get(String url, Map<String, String> params) {
		CloseableHttpClient httpclient = getClient();
		try {
			StringBuilder query = new StringBuilder();
			if(params != null && params.size() > 0){
				for (String param : params.keySet()) {
					if(query.length() > 0) query.append("&");
					query.append(param + "=");
					query.append(URLEncoder.encode(params.get(param), "UTF-8"));
				}
			}
			if(query.length() > 0){
				String join = "?";
				if(url.contains(join)) //ԭurl����querystring
					join = "&";
				url = url + join + query.toString();
			}
			HttpGet httpget = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(sTimeout).setConnectTimeout(conTimeout).build();
            httpget.setConfig(requestConfig);

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						String charset = null;
						if(entity!=null){
							ContentType ct = ContentType.getOrDefault(entity);
							charset = ct.getCharset() == null ? "ISO-8859-1":ct.getCharset().toString();
						}
						return entity != null ? EntityUtils.toString(entity,charset) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}

			};
			
			String responseBody = httpclient.execute(httpget, responseHandler);
			return responseBody;
		} catch (ClientProtocolException e) {
			log.error("call url:"+url+" error.",e);
		} catch (Exception e) {
			log.error("call url:"+url+" error.",e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "error";
	}
	
	public static JSONObject parseJson(String res) {
		JSONObject jObject = JSONObject.fromObject(res);
		return jObject;
	}
	
	
	public static void main(String args[]){
		//grant_type=password&username=autocratel@163.com&password=Welcome2sohu!
		Map map = new HashMap();
		map.put("client_id", "0oQthCIZ2E");
		map.put("client_secret", "G8IAPMFjuG7BF3PiRoa7Bv");
		map.put("grant_type", "password");
		map.put("username", "autocratel@163.com");
		map.put("password", "Welcome2sohu!");
		String result = post("https://xueqiu.com/provider/oauth/token", map);
		JSONObject json = JSONObject.fromObject(result);
		String token = json.getString("access_token");
		System.out.println("token:" + token);
		
		
		//http://api.xueqiu.com/statuses/stock_public_timeline.json?symbol=aapl&sort=time&count=2&pa
		//ge=1&access_token=
		Map map2 = new HashMap();
		map2.put("access_token", token);
		map2.put("code", "AAPL,SZ000001");
		String result2 = get("http://api.xueqiu.com/v4/stock/quote.json",
				map2);
		//String test = "sda";
		System.out.println(result2);
		
	}

}
