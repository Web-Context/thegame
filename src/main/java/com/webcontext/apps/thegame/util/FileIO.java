package com.webcontext.apps.thegame.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.log4j.Logger;

/**
 * File IO utils.
 * 
 * @author frederic
 * 
 */
public class FileIO {

	private static final Logger logger = Logger.getLogger(FileIO.class);

	/**
	 * try to detect the Type of a file.
	 * 
	 * @param path
	 * @return
	 */
	public static String getContentType(String path) {
		String type = "";
		try {
			type = Files.probeContentType(FileSystems.getDefault().getPath(
					getResource(path)));
		} catch (IOException e) {
			logger.error("Unable to identify content.");
		}
		return type;
	}

	/**
	 * Gets an absolute path from a relative path
	 * 
	 * @param path
	 *            - The relative path of a resource
	 * @return The relative path's absolute path
	 */
	public static String getResource(String path) {
		try {
			return URLDecoder.decode(ClassLoader.getSystemClassLoader()
					.getResource(URLDecoder.decode(path, "UTF-8")).getPath(),
					"UTF-8");
		} catch (UnsupportedEncodingException | NullPointerException e) {
			// This will only happen if the file doesn't exist and is handled
			// later.
			return "";
		}
	}

	/**
	 * Load <code>filePath</code> text file to a String.
	 * 
	 * @param filePath
	 *            File to be read.
	 * @return a string containing all the file content.
	 * @throws IOException
	 */
	@Deprecated
	public static String loadAsString(String file) throws IOException {
		return fastRead(file);
	}

	/**
	 * Quick reading of file <code>name</code> to a String.
	 * 
	 * @param name
	 *            File to load to String.
	 * @return string containing all the file content
	 * @throws IOException
	 */
	public static String fastRead(String file) throws IOException {

		URL resourceURL1 = Thread.currentThread().getContextClassLoader()
				.getResource("/");

		String fullPath = FileIO.class.getClassLoader().getResource("/")
				.getPath();
		Path filePath = new File(fullPath + file).toPath();
		return new String(Files.readAllBytes(filePath));
	}
}
