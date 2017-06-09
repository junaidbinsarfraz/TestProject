
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import crawlercommons.robots.BaseRobotRules;
import crawlercommons.robots.SimpleRobotRules;
import crawlercommons.robots.SimpleRobotRules.RobotRulesMode;
import crawlercommons.robots.SimpleRobotRulesParser;

public class CrawlUtil {

	public static BaseRobotRules getWebsiteRules(String userAgent, String url) throws Exception {

		URL urlObj = new URL(url);
		String hostId = urlObj.getProtocol() + "://" + urlObj.getHost() + (urlObj.getPort() > -1 ? ":" + urlObj.getPort() : "");
		BaseRobotRules rules = null;
		HttpGet httpget = new HttpGet(hostId + "/robots.txt");
		HttpContext context = new BasicHttpContext();
		HttpClient httpclient = HttpClientBuilder.create().build();
		HttpResponse response = httpclient.execute(httpget, context);

		if (response.getStatusLine() != null && response.getStatusLine().getStatusCode() == 404) {
			rules = new SimpleRobotRules(RobotRulesMode.ALLOW_ALL);
			// consume entity to deallocate connection
			EntityUtils.consume(response.getEntity());
		} else {
			BufferedHttpEntity entity = new BufferedHttpEntity(response.getEntity());
			SimpleRobotRulesParser robotParser = new SimpleRobotRulesParser();
			rules = robotParser.parseContent(hostId, IOUtils.toByteArray(entity.getContent()), "text/plain", userAgent);
		}

		return rules;
	}

	public static Boolean isAllowed(BaseRobotRules rules, String baseUrl, String toUrl) {

		if (Boolean.TRUE.equals(isWithinDomain(baseUrl, toUrl))) {

			if (rules == null || rules.isAllowAll() || rules.isAllowed(toUrl)) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	public static Boolean isWithinDomain(String baseUrl, String toUrl) {

		try {
			if (getDomainName(baseUrl).equals(getDomainName(toUrl)) || getDomainName(toUrl).contains(getDomainName(baseUrl))) {
				return Boolean.TRUE;
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return Boolean.FALSE;
	}

	public static String getDomainName(String url) throws URISyntaxException {
		URI uri = new URI(url);
		String domain = uri.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}
	
	
	
	
	
	
	
	
	
	
	
	private static HashMap<String, HashMap<String, String>> host2cookies = new HashMap<String, HashMap<String, String>>();

	public static String[] DownloadPage(URL url) throws Exception
	{
	    Connection con = Jsoup.connect(url.toString()).timeout(600000);
	    loadCookiesByHost(url, con);


	    Document doc = con.get();
	    url = con.request().url();

	    storeCookiesByHost(url, con);

	    return new String[]{url.toString(), doc.html()};
	}

	private static void loadCookiesByHost(URL url, Connection con) {
	    try {
	        String host = url.getHost();
	        if (host2cookies.containsKey(host)) {
	            HashMap<String, String> cookies = host2cookies.get(host);
	            for (Entry<String, String> cookie : cookies.entrySet()) {
	                con.cookie(cookie.getKey(), cookie.getValue());
	            }
	        }
	    } catch (Throwable t) {
	        // MTMT move to log
	        System.err.println(t.toString()+":: Error loading cookies to: " + url);
	    }
	}

	private static void storeCookiesByHost(URL url, Connection con) {
	        try {
	            String host = url.getHost();
	            HashMap<String, String> cookies = host2cookies.get(host);
	            if (cookies == null) {
	                cookies = new HashMap<String, String>();
	                host2cookies.put(host, cookies);
	            }
	            cookies.putAll(con.response().cookies());
	        } catch (Throwable t) {
	            // MTMT move to log
	            System.err.println(t.toString()+":: Error saving cookies from: " + url);
	        }    
	}   

}