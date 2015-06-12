package com.weng.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hibernate.sql.Insert;

public class ParseStock {
	public static void main(String[] args) throws IOException {
		/*InputStreamReader isr = new InputStreamReader(new FileInputStream("stock"), "utf-8");
		
		int c = 0;
		while ((c=isr.read()) >= 0) {
			System.out.println((char)c + "::" + c);
		}
		
		isr.close();
		*/
		
/*		
 * 		File file = new File("stock");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line=br.readLine()) != null){
//			System.out.println(line);
			String[] a = line.split(" ");
			if (a.length!=3){
				System.out.println(line);
			}
		}*/
		
		List list = new ArrayList();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("stock.txt"), true));
		

		bw.write("<div class=\"tab-stock tab-stock-tt\">\n");
		bw.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
		bw.write("<colgroup><col width=\"150\"><col width=\"110\"><col width=\"*\">\n");
		bw.write("</colgroup><tbody><tr>\n");
		bw.write("<th>行情</th>\n");
		bw.write("<th>股价</th>\n");
		bw.write("<th>涨幅</th>\n");
		bw.write("</tr>\n");
		bw.write("</tbody></table>\n");
		bw.write("</div>\n");
		
		bw.write("<div class=\"tab-stock\">\n");
		bw.write("<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
		bw.write("<colgroup><col width=\"120\"><col width=\"110\"><col width=\"*\">\n");
		bw.write("</colgroup><tbody>\n");	
	
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("stock"), "utf-8"));
		String line;
		while((line = br.readLine()) != null) {
			String[] a = line.split(" ");
			if (3 == a.length){
				JSONArray ja = getInfoFromXueqiu(a[2]);
				if(ja.getString(2).startsWith("-")){
					bw.write("<tr>\n");
					bw.write("<td class=\"tl\"><a href=" + "http://xueqiu.com/S/" + a[2] +" target=\"_blank\">" + a[1] + "</a></td>\n");
					bw.write("<td class=\"red\">" + ja.get(0)+ "</td>\n");
					bw.write("<td class=\"red tr\">" + ja.get(2) + "%</td>\n");
					bw.write("</tr>\n");
				}else {
					bw.write("<tr>\n");
					bw.write("<td class=\"tl\"><a href=" + "http://xueqiu.com/S/" + a[2] +" target=\"_blank\">" + a[1] + "</a></td>\n");
					bw.write("<td class=\"green\">" + ja.get(0)+ "</td>\n");
					bw.write("<td class=\"green tr\">" + ja.get(2) + "%</td>\n");
					bw.write("</tr>\n");
				}
			} else {
				bw.write("<tr><td class=\"stock-tt\" colspan=\"3\">中国概念股(" + line +")</td></tr>\n");
			}
		}
		br.close();
		
		
		bw.write("</tbody></table>\n");
		bw.write("</div>\n");
		bw.close();
		
	}

	private static JSONArray getInfoFromXueqiu(String code) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("access_token", "fTq1tMP8jrUKgERleTB4yq");
		map.put("code", code);
		String result = HttpUtil.get("http://api.xueqiu.com/v4/stock/quotec.json", map);
		
		JSONObject json = JSONObject.fromObject(result);
		return json.getJSONArray(code);
		
	}
}
