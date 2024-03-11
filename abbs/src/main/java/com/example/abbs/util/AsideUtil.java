package com.example.abbs.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:/static/data/myKeys.properties")
public class AsideUtil {
	@Value("roadAddrKey") private String roadAddrKey;
	@Value("KakaoApiKey") private String KakaoApiKey;
	@Value("openWeatherApikey")	private String openWeatherApikey;

	public String getTodayQuote(String filename) {
		String result = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename), 1024);
			int index = (int) Math.floor(Math.random() * 100);
			for (int i = 0; i < index; i++)
				result = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String getRoadAddr(String keyword) throws Exception {
		String roadAddr = null;
		try {
			keyword = URLEncoder.encode(keyword, "utf-8");
			String apiUrl = "https://www.juso.go.kr/addrlink/addrLinkApi.do" + "?confmKey=" + roadAddrKey
					+ "&currentPage=1&countPerPage=5&resultType=json" + "&keyword=" + keyword;
			System.out.println(apiUrl);
			URL url = new URL(apiUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			String line = null, result = "";
			while ((line = br.readLine()) != null) 
				result += line;
			System.out.println(result);
			br.close();
			
			// JSON 데이터에서 원하는 값 추출하기
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(result.toString());
			JSONObject results = (JSONObject) object.get("results");
			JSONArray juso = (JSONArray) results.get("juso");
			JSONObject jusoItem = (JSONObject) juso.get(0);
			roadAddr = (String) jusoItem.get("roadAddr");
			} 
		catch (Exception e) {
			e.printStackTrace();
		}



		return roadAddr;
	}

}
