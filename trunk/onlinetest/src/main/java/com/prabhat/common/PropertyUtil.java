package com.prabhat.common;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyUtil {

	private Properties cabPropertiy = new Properties();
	private static PropertyUtil _instance;

	private PropertyUtil() {
		ClassLoader classLoader = getClass().getClassLoader();

		try {
			URL url = classLoader.getResource("test.properties");
			if (url != null) {
				InputStream is = url.openStream();
				cabPropertiy.load(is);
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static PropertyUtil _getInstance() {
		if (_instance == null) {
			synchronized (PropertyUtil.class) {
				if (_instance == null) {
					_instance = new PropertyUtil();
				}
			}
		}

		return _instance;
	}

	public static String get(String key) {
		String value = _getInstance().cabPropertiy.getProperty(key);
		return value;
	}

	public static void main(String[] s) {
		System.out.println(get("cab.edit.error.msg"));
	}
}
