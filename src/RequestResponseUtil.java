import org.jsoup.Connection;

public class RequestResponseUtil {

	public static Connection makeRequest() {

		// TODO: Make connection

		return null;

	}

	public static String refectorUrl(String url, String domain) {
		String newUrl = null;

		if (url != null && !url.isEmpty()) {

			if (!url.startsWith("http")) {
				if (url.startsWith("//")) {
					newUrl = "https:" + url;
				} else if (url.startsWith("/")) {
					newUrl = "https://" + domain + url;
				}
			} else {
				newUrl = url;
			}

		}

		return newUrl;
	}

}
