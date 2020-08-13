package com.prenetics.common.utility.http;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;


public class InputStreamConverter {

	private final static Logger logger = Logger.getLogger(InputStreamConverter.class);
	private InputStream stream;

	public InputStreamConverter() {
	}

	public InputStreamConverter(InputStream stream) {
		setStream(stream);
	}

	public void setStream(String url) {
		InputStream stream = (new HTTPRequester(url)).request();
		setStream(stream);
	}
    public void setStream(InputStream stream) {
        this.stream = stream;
    }


	public JSONObject toJSONObject() {
		String string = toString();
		JSONObject parsed = new JSONObject(string);
		return parsed;
	}

    public void toOfflineFile(String path) {
        File filePath = new File(path);
        File directoryPath = filePath.getParentFile();
        if (directoryPath.mkdirs()) {
            logger.info("toOfflineFile :: created directory : " + directoryPath.getAbsolutePath());
        }
        try (OutputStream os = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = stream.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Cannot save to file -- " + e.getMessage());
        }
    }

	public Properties toProperties() {
		Properties result = new Properties();
		try {
			InputStreamReader reader = getInputStreamReader();
			result.load(reader);
		} catch (IOException e) {
			logger.error("Cannot convert to Properties -- " + e.getMessage());
		}
		return result;
	}

	
	@Override
	public String toString() {
		String string = "";
		try {
			InputStreamReader reader = getInputStreamReader();
			BufferedReader buffer = new BufferedReader(reader);
			String line;
			StringBuilder builder = new StringBuilder();
			while ((line = buffer.readLine()) != null) {
				builder.append(line).append("\n");
			}
			string = builder.toString();
		} catch (IOException e) {
			logger.error("Cannot convert to String -- " + e.getMessage());
		}
		return string;
	}


	public Workbook toWorkbook() {
		Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(stream);
		} catch (Exception e) {
			logger.error("Cannot convert to Workbook -- " + e.getMessage());
		}
		return workbook;
	}

	private InputStreamReader getInputStreamReader() {
		return new InputStreamReader(stream, Charset.forName("UTF-8"));
	}
}
