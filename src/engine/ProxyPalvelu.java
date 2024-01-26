package engine;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class ProxyPalvelu {

	public static void main(String[] args) {
	    WebConversation wc = new WebConversation();
	    WebRequest     req = new GetMethodWebRequest( "http://www.meterware.com/testpage.html" );
	    try {
			WebResponse   resp = wc.getResponse( req );
			String sivunTeksti = resp.getText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
