package engine;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProxyPalvelu {

	public void aja() {

		try {
			// Create connection
			URL url = new URL("https://www.kanair.fi/category/10/ilmailupolttoaineet--aviation-fuel");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			// connection.setRequestProperty("Content-Length",
			// Integer.toString(urlParameter.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			// wr.writeBytes(urlParameters);
			wr.close();

			// Get Response
			InputStream is = connection.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is));
			StringBuilder response = new StringBuilder();

			String line = "";
			String allLines = "";
			while ((line = rd.readLine()) != null) {
				response.append(line);
				line = line.trim();
				allLines = allLines + line;

				response.append('\r');
			}
			int taulukonEkaKohta = allLines.indexOf("&lt;table&gt");
			int taulukonTokaKohta = allLines.indexOf("&lt;/table&gt;");
			String taulukonSisalto = allLines.substring(taulukonEkaKohta, taulukonTokaKohta);
			taulukonSisalto = taulukonSisalto.replace("&lt;", "<");
			taulukonSisalto = taulukonSisalto.replace("&gt;", ">");

			try {


				String html = taulukonSisalto;
				Document document = Jsoup.parse(html);

				// Find the table element using its tag name
				Element table = document.select("table").first();

				// Check if a table is found
				if (table != null) {
					// Get all rows in the table
					Elements rows = table.select("tr");

					// Iterate through each row
					for (Element row : rows) {
						// Get all columns in the row
						Elements columns = row.select("td");

						// Iterate through each column
						for (Element column : columns) {
							System.out.print(column.text() + "\t");
						}

						// Move to the next line after each row
						System.out.println();
					}
				} else {
					System.out.println("No table found on the page.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			//System.out.println(taulukonSisalto);
			rd.close();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// if (connection != null) {
			// connection.disconnect();
			// }
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting Arkipaivareporter");
		ProxyPalvelu olio = new ProxyPalvelu();
		olio.aja();
	}

}
