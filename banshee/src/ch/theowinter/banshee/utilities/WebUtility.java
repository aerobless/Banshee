package ch.theowinter.banshee.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

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
}
