package ch.theowinter.banshee.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class WebUtility {
	
	/**
	 * Downloads a website and returns a string containing the html
	 * or xml data.
	 *
	 * @param httpURL
	 * @return data
	 * @throws IOException
	 */
	public String webToString(String httpURL) throws IOException{
		URL url = new URL(httpURL);
		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buf = new byte[8192];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
		    baos.write(buf, 0, len);
		}
		return new String(baos.toByteArray(), encoding);
	}
	
	public void readXML(String input) throws SAXException, IOException, ParserConfigurationException{
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(input);
		String usr = document.getElementsByTagName("user").item(0).getTextContent();
		String pwd = document.getElementsByTagName("password").item(0).getTextContent();
	}
}
