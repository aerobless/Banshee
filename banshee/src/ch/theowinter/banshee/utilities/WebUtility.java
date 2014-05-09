package ch.theowinter.banshee.utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;

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
	
	/**
	 * Generate a md5 value as a string from a string.
	 *
	 * @param input
	 * @return md5
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public String MD5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	    java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	    byte[] array = md.digest(input.getBytes("UTF-8"));
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < array.length; ++i) {
	      sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	    }
	    return sb.toString();
	}
}
