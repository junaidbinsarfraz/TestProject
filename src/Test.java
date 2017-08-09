import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
	
	static List<String> usernameKeys = Arrays.asList("ctl00$ctl02$tbEmail", "usernmae", "email", "login", "login[username]", "logonId");
	
	static List<String> passwordKeys = Arrays.asList("ctl00$ctl02$tbPassword", "password", "pass", "login[password]", "logonPassword");
	
	static 	List<String> loginKeys = Arrays.asList("Login", "Signin", "Sign in", "Log in");
	
	static 	List<String> logoutKeys = Arrays.asList("Logout", "Signout", "Sign out", "Log out");
	
	static String loginUsername = "enquiries@loadmetrics.co.uk";
	
	static String loginPassword = "#Unst0n3#";
	
	public static void main(String[] args) throws IOException {
		
		/*try {
			Document doc = makeRequest("https://profile.theguardian.com/signin?INTCMP=DOTCOM_HEADER_SIGNIN", 
										"https://www.theguardian.com/uk");
			
			System.out.println(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		Connection.Response loginForm = Jsoup.connect("https://www.theguardian.com/uk")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
                .method(Connection.Method.GET)
                .execute();

        Document doc = loginForm.parse();

        Elements hiddenElems = doc.select("input[type=hidden]");
        Map<String, String> nameValue = new HashMap<>();

        for(Element elem : hiddenElems) {
            nameValue.put(elem.attr("name"), elem.attr("value"));
        }

        Document document = Jsoup.connect("https://profile.theguardian.com/signin/actions/signin")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
                .data("email", loginUsername)
                .data("password", loginPassword)
                .data(nameValue)
                .cookies(loginForm.cookies())
                .post();
        
        System.out.println(document);
        
        
		/*Connection.Response loginForm = Jsoup.connect("http://www.investabroadproperties.com/")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
                .method(Connection.Method.GET)
                .execute();

        Document doc = loginForm.parse();

        Elements hiddenElems = doc.select("input[type=hidden]");
        Map<String, String> nameValue = new HashMap<>();

        for(Element elem : hiddenElems) {
            nameValue.put(elem.attr("name"), elem.attr("value"));
        }
        
        System.out.println(nameValue);

        Document document = Jsoup.connect("http://www.investabroadproperties.com/")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
                .data("ctl00$ctl02$tbEmail", "enquiries@loadmetrics.co.uk")
                .data("ctl00$ctl02$tbPassword", "#Unst0n3#")
                .data(nameValue)
//                .data("ctl00$ctl02$btnLogonLogout", "Login")
                .cookies(loginForm.cookies())
                .post();
//                .method(Connection.Method.POST)
//                .execute();
        
        System.out.println(document);*/
		
		/*try {

	        Connection.Response response = Jsoup.connect("http://www.investabroadproperties.com/UserLogin.aspx/")
	                .method(Connection.Method.GET)
	                .execute();

	        Document doc = response.parse();

	        Elements hiddenElems = doc.select("input[type=hidden]");
	        Map<String, String> nameValue = new HashMap<>();

	        for(Element elem : hiddenElems) {
	            nameValue.put(elem.attr("name"), elem.attr("value"));
	        }

	        Map<String, String> authCookie = response.cookies();

	        response = Jsoup.connect("http://www.investabroadproperties.com/UserLogin.aspx/")
	                .method(Connection.Method.POST)
	                .data("ctl00$ctl01$tbEmail", "enquiries@loadmetrics.co.uk") // your email
	                .data("ctl00$ctl01$tbPassword", "#Unst0n3#") // your password
//	                .data("__EVENTVALIDATION", eventValidation)
//	                .data("__VIEWSTATEGENERATOR", viewStateGenerator)
	                .data("ctl00$ctl01$btnLogonLogout", "Login")
//	                .data("DES_LinkIDState", desLinkIdState)
//	                .data("DES_ScriptFileIDState", desScriptFileIDState)
//	                .data("__VIEWSTATE", viewState)
	                .data(nameValue)
	                .cookies(authCookie)
	                .execute();
	        
	        System.out.println("___");
	        System.out.println(response.body()); // full html response

	        response = Jsoup.connect("http://www.investabroadproperties.com/UserHome.aspx")
	                .method(Connection.Method.GET)
	                .cookies(authCookie)
	                .execute();

	        System.out.println(response.parse().select("div#members_switch").text());
	        System.out.println("___");
	        System.out.println(response.body()); // full html response

	    } catch (IOException e) {
	        e.printStackTrace();
	    }*/
		
		
		/*Connection.Response loginForm = Jsoup.connect("https://www.sportfish.co.uk/customer/account/login/")
				.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
	            .method(Connection.Method.GET)
	            .execute();
		
		Document doc = loginForm.parse();
		
		List<String> usernameKeys = Arrays.asList("ctl00$ctl02$tbEmail", "usernmae", "email", "login", "login[username]");
		
		List<String> passwordKeys = Arrays.asList("ctl00$ctl02$tbPassword", "password", "pass", "login[password]");
		
		List<String> loginKeys = Arrays.asList("Login", "Signin", "Sign in");
		
		AuthenticationForm form = findForm(doc, usernameKeys, passwordKeys, loginKeys);
		
		Elements hiddenElems = doc.select("input[type=hidden]");
		Map<String, String> nameValue = new HashMap<>();
		
		for(Element elem : hiddenElems) {
			nameValue.put(elem.attr("name"), elem.attr("value"));
		}*/
		
	    /*Document document = Jsoup.connect("http://www.investabroadproperties.com/")
	    		.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
	            .data("ctl00$ctl02$tbEmail", "enquiries@loadmetrics.co.uk")
	            .data("ctl00$ctl02$tbPassword", "#Unst0n3#")
	            .data(nameValue)
	            .cookies(loginForm.cookies())
	            .post();
	    
	    System.out.println(document);*/
		
		/*Connection connection = Jsoup.connect("http://www.indiatimes.com/news/india/indian-air-force-to-get-made-in-india-awacs-planes-to-look-deep-into-pakistan-and-china-268889.html");

	    connection.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1");
	    connection.timeout(30 * 1000);

	    Document htmlDoc = connection.get();
	    
	    String htmlString = htmlDoc.html();
		
	    // Write it to file
	    File newHtmlFile = new File("latest.html");
	    
	    FileUtils.writeStringToFile(newHtmlFile, htmlString);
		*/
		/*Connection connection = Jsoup.connect("http://webforumtestsolutions.co.uk").proxy("127.0.0.1", 8887);

	    connection.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1");
	    connection.timeout(30 * 1000);

	    connection.get();*/
	    
		/*// Engine
        StandardJMeterEngine jm = new StandardJMeterEngine();
        // jmeter.properties
        JMeterUtils.loadJMeterProperties("jmeter.properties");

		HashTree hashTree = new HashTree();

		// HTTP Sampler
		HTTPSampler httpSampler = new HTTPSampler();
		httpSampler.setDomain("www.google.com");
		httpSampler.setPort(8889);
		httpSampler.setPath("/");
		httpSampler.setMethod("GET");

		// Loop Controller
		TestElement loopCtrl = new LoopController();
		((LoopController) loopCtrl).setLoops(1);
		((LoopController) loopCtrl).addTestElement(httpSampler);
		((LoopController) loopCtrl).setFirst(true);

		// Thread Group
		SetupThreadGroup threadGroup = new SetupThreadGroup();
		threadGroup.setNumThreads(1);
		threadGroup.setRampUp(1);
		threadGroup.setSamplerController((LoopController) loopCtrl);

		// Test plan
		TestPlan testPlan = new TestPlan("MY TEST PLAN");

		hashTree.add("testPlan", testPlan);
		hashTree.add("loopCtrl", loopCtrl);
		hashTree.add("threadGroup", threadGroup);
		hashTree.add("httpSampler", httpSampler);

		jm.configure(hashTree);

		jm.run();

		while (true) {
			try {
				URL url = new URL("http://webforumtestsolutions.co.uk/index.html");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8889));
				HttpURLConnection uc = (HttpURLConnection) url.openConnection();
				uc.usingProxy();
				uc.setRequestMethod("GET");
				uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1");

				uc.connect();

				String line = null;
				StringBuffer tmp = new StringBuffer();
				BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
				while ((line = in.readLine()) != null) {
					tmp.append(line);
				}

				Document doc = Jsoup.parse(String.valueOf(tmp));
				
				System.out.println("Passed");

			} catch (Exception e) {
				System.out.println(e);
			}
		}*/

		/*
		 * // Engine StandardJMeterEngine jm = new StandardJMeterEngine(); //
		 * jmeter.properties
		 * JMeterUtils.loadJMeterProperties("jmeter.properties");
		 * 
		 * HashTree hashTree = new HashTree();
		 * 
		 * // HTTP Sampler HTTPSampler httpSampler = new HTTPSampler(); //
		 * httpSampler.setDomain("www.google.com"); httpSampler.setPort(80);
		 * httpSampler.setPath("/"); httpSampler.setMethod("GET");
		 * 
		 * // Loop Controller TestElement loopCtrl = new LoopController();
		 * ((LoopController)loopCtrl).setLoops(1);
		 * ((LoopController)loopCtrl).addTestElement(httpSampler);
		 * ((LoopController)loopCtrl).setFirst(true);
		 * ((LoopController)loopCtrl).setContinueForever(true);
		 * 
		 * // Thread Group SetupThreadGroup threadGroup = new
		 * SetupThreadGroup(); threadGroup.setNumThreads(1);
		 * threadGroup.setRampUp(1);
		 * threadGroup.setSamplerController((LoopController)loopCtrl);
		 * 
		 * // Test plan TestPlan testPlan = new TestPlan("MY TEST PLAN");
		 * 
		 * hashTree.add("testPlan", testPlan); hashTree.add("loopCtrl",
		 * loopCtrl); hashTree.add("threadGroup", threadGroup);
		 * hashTree.add("httpSampler", httpSampler);
		 * 
		 * jm.configure(hashTree);
		 * 
		 * System.out.println(jm.isActive());
		 * 
		 * jm.run();
		 * 
		 * System.out.println(jm.isActive());
		 * 
		 * while(true);
		 */

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Junaid\\geckodriver\\geckodriver.exe"); File pathToBinary = new
		 * File("Firefox\\App\\Firefox64\\firefox.exe"); FirefoxBinary ffBinary
		 * = new FirefoxBinary(pathToBinary); FirefoxProfile firefoxProfile =
		 * new FirefoxProfile();
		 * firefoxProfile.setPreference("toolkit.startup.max_resumed_crashes",
		 * "-1");
		 */

		/*
		 * FirefoxOptions opts = new FirefoxOptions().setLogLevel(Level.OFF);
		 * DesiredCapabilities capabilities =
		 * opts.addTo(DesiredCapabilities.firefox());
		 * capabilities.setCapability("marionette", true);
		 */

		/*
		 * @SuppressWarnings("deprecation") WebDriver driver = new
		 * FirefoxDriver(ffBinary,firefoxProfile);
		 * driver.get("http://www.google.com/"); File scrFile =
		 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Now
		 * you can do whatever you need to do with it, for example copy
		 * somewhere FileUtils.copyFile(scrFile, new
		 * File("d:\\Junaid\\screenshot.png"));
		 * 
		 * driver.get(
		 * "https://stackoverflow.com/questions/21287677/firefox-disable-automatic-safe-mode-after-crash"
		 * ); scrFile =
		 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Now
		 * you can do whatever you need to do with it, for example copy
		 * somewhere FileUtils.copyFile(scrFile, new
		 * File("d:\\Junaid\\screenshot1.png"));
		 * 
		 * killFirefox();
		 */

		/*
		 * Double d = -11.0;
		 * 
		 * try { CrawlUtil.DownloadPage(new URL("https://www.javatpoint.com"));
		 * } catch (Exception e1) { e1.printStackTrace(); }
		 * 
		 * if(true) { return; }
		 * 
		 * try {
		 * 
		 * String webUrl = "https://github.com/";
		 * 
		 * BaseRobotRules rules = null;
		 * 
		 * try { rules = CrawlUtil.getWebsiteRules(
		 * "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1"
		 * , webUrl); } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * 
		 * rules.isAllowed(webUrl + "/error");
		 * 
		 * URL url = new URL(webUrl);
		 * 
		 * URLConnection conn = url.openConnection();
		 * 
		 * 
		 * String baseDomain = CrawlUtil.getDomainName(webUrl);
		 * 
		 * Connection connection = Jsoup.connect(webUrl) .userAgent(
		 * "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1"
		 * ) .timeout(20 * 1000);
		 * 
		 * Document htmlDocument = connection.get();
		 * 
		 * 
		 * 
		 * if (connection.response().statusCode() == 200) {
		 * 
		 * Elements links = htmlDocument.select("a[href]");
		 * 
		 * for (Element link : links) {
		 * 
		 * try { System.out.println(link.attr("href"));
		 * 
		 * System.out.println(RequestResponseUtil.refectorUrl(link.attr("href"),
		 * baseDomain));
		 * 
		 * System.out.println(CrawlUtil.isWithinDomain(webUrl,
		 * RequestResponseUtil.refectorUrl(link.attr("href"), baseDomain)) +
		 * "\n"); } catch (Exception e) { System.err.println(link.attr("href"));
		 * } } }
		 */

		/*
		 * Map<String, List<String>> map = conn.getHeaderFields();
		 * 
		 * System.out.println("Printing Response Header...\n");
		 * 
		 * for (Map.Entry<String, List<String>> entry : map.entrySet()) {
		 * System.out.println("Key : " + entry.getKey() + " ,Value : " +
		 * entry.getValue()); }
		 */

	}

	private static void killFirefox() {
		Runtime rt = Runtime.getRuntime();

		try {
			rt.exec("taskkill /F /IM firefox.exe");
			while (processIsRunning("firefox.exe")) {
				Thread.sleep(100);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean processIsRunning(String process) {
		boolean processIsRunning = false;
		String line;
		try {
			Process proc = Runtime.getRuntime().exec("wmic.exe");
			BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
			oStream.write("process where name='" + process + "'");
			oStream.flush();
			oStream.close();
			while ((line = input.readLine()) != null) {
				if (line.toLowerCase().contains("caption")) {
					processIsRunning = true;
					break;
				}
			}
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return processIsRunning;
	}
	
	public static Boolean isLoginSuccessful(Document document, AuthenticationForm loginForm) {
		
		if(loginForm == null) {
			return Boolean.FALSE;
		}
		
		// Locate authentication form
		Object form = null;
		form = findAndFillForm(document, usernameKeys, passwordKeys, loginKeys, loginUsername, loginPassword);
		if(form != null) {
			return Boolean.FALSE;
		}
		
		// Locate logout button/link, if found then return true
		
		// Locate error message if found the return false
		
		
		return Boolean.TRUE;
	}
	
	public static Document makeRequest(String loginLink, String domainUrl) throws Exception {
		//"https://www.rightmove.co.uk/login.html"
		Connection.Response loginForm = Jsoup.connect(loginLink)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
                .method(Connection.Method.GET)
                .execute();

        Document doc = loginForm.parse();
        
        AuthenticationForm form = findAndFillForm(doc, usernameKeys, passwordKeys, loginKeys, loginUsername, loginPassword);
        
        String actionUrl = beautifyActionUrl(form.getForm().attr("action"), domainUrl);
        
        Document document = Jsoup.connect(actionUrl)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
//                .method(Connection.Method.POST)
                .data(form.getData())
                .cookies(loginForm.cookies())
                .post();
        
        Boolean isSuccessful = isLoginSuccessful(document, form);
        
        if(isSuccessful) {
        	return document;
        }
		
		return null;
	}
	
	public static String beautifyActionUrl(String actionUrl, String domainUrl) {
		if(actionUrl.startsWith("http://") || actionUrl.startsWith("https://")) {
			return actionUrl;
		}
		
		if(actionUrl.equals("/") || actionUrl.equals("./")) {
			return domainUrl;
		}
		
		
		return (domainUrl + actionUrl);//.replace("/([^:]\\/)\\/+/g", "$1");
	}
	
	public static AuthenticationForm findAndFillForm(Document document, List<String> usernameKeys, List<String> passwordKeys, List<String> loginKeys, String username, String password) {
		
		AuthenticationForm loginForm = null;
		
		Elements forms = document.getElementsByTag("form");
		
		if(forms.size() > 0) {
			
			for(Element myForm : forms) {
				// Get username and password field to check if form is login form or not
				// Also check for button or link's text if its login or not because it can be register link
				
				for(String usernameKey : usernameKeys) {
					Elements usernameElems = myForm.getElementsByAttributeValue("name", usernameKey);
					
					if(usernameElems.size() > 0) {
						for(String passwordKey : passwordKeys) {
							Elements passwordElems = myForm.getElementsByAttributeValue("name", passwordKey);
							
							if(passwordElems.size() > 0) {
								// Check for login button or link
								
								Elements loginButton = myForm.getElementsByAttributeValue("type", "submit");
								
								for(String loginKey : loginKeys) {
									
									if(loginButton.size() > 0) {
										if(loginKey.equalsIgnoreCase(loginButton.first().attr("title")) || loginKey.equalsIgnoreCase(loginButton.first().text())
											|| loginButton.first().html().toLowerCase().contains(loginKey.toLowerCase()) || loginKey.equalsIgnoreCase(loginButton.first().attr("value"))) {
											// Login button/link exists
											
											Elements hiddenElems = myForm.select("input[type=hidden]");
									        Map<String, String> nameValue = new HashMap<>();

									        for(Element elem : hiddenElems) {
									            nameValue.put(elem.attr("name"), elem.attr("value"));
									        }
									        
									        nameValue.put(passwordElems.first().attr("name"), loginPassword);
									        nameValue.put(usernameElems.first().attr("name"), loginUsername);
									        
									        if(loginButton.first().attr("name") != null && loginButton.first().attr("name") != "") {
									        	nameValue.put(loginButton.first().attr("name"), loginButton.first().attr("value"));
									        }
											
											loginForm = new AuthenticationForm();
											
											loginForm.setData(nameValue);
											loginForm.setForm(myForm);
											loginForm.setPasswordField(passwordElems.first());
											loginForm.setUsernameField(usernameElems.first());
											loginForm.setLoginBtnField(loginButton.first());
											
											break;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return loginForm;
	}

}
