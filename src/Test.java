import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Junaid\\geckodriver\\geckodriver.exe");
		File pathToBinary = new File("D:\\Junaid\\No Need\\FirefoxPortable\\App\\Firefox64\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();       
		firefoxProfile.setPreference("toolkit.startup.max_resumed_crashes", "-1");
		WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);
		driver.get("http://www.google.com/");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("d:\\Junaid\\screenshot.png"));
		
		driver.get("https://stackoverflow.com/questions/21287677/firefox-disable-automatic-safe-mode-after-crash");
		scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("d:\\Junaid\\screenshot1.png"));
		
		killFirefox();
		
		
		
		
		/*Double d = -11.0;

		try {
			CrawlUtil.DownloadPage(new URL("https://www.javatpoint.com"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		if(true) {
			return;
		}

		try {

			String webUrl = "https://github.com/";

			BaseRobotRules rules = null;

			try {
				rules = CrawlUtil.getWebsiteRules(
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1", webUrl);
			} catch (Exception e) {
				e.printStackTrace();
			}

			
			 * rules.isAllowed(webUrl + "/error");
			 * 
			 * URL url = new URL(webUrl);
			 * 
			 * URLConnection conn = url.openConnection();
			 

			String baseDomain = CrawlUtil.getDomainName(webUrl);

			Connection connection = Jsoup.connect(webUrl)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1")
					.timeout(20 * 1000);

			Document htmlDocument = connection.get();
			
			

			if (connection.response().statusCode() == 200) {

				Elements links = htmlDocument.select("a[href]");

				for (Element link : links) {

					try {
						System.out.println(link.attr("href"));

						System.out.println(RequestResponseUtil.refectorUrl(link.attr("href"), baseDomain));
						
						System.out.println(CrawlUtil.isWithinDomain(webUrl, RequestResponseUtil.refectorUrl(link.attr("href"), baseDomain)) + "\n");
					} catch (Exception e) {
						System.err.println(link.attr("href"));
					}
				}
			}*/

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


}
