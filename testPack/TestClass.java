package testPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.stream.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.json.XML;
import org.json.simple.JSONValue;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

import abbyy.cloudsdk.v2.sample.*;

public class TestClass {
	
	public static CliSession sess = new CliSession();

	public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
//		String str1 = "textjkdewgye\n wryiuwv\nfvxc\ncc";
//		String str2 = str1.replaceAll("\n", "");
//		System.out.println(str2);
		System.out.println("Enter path ");
		Scanner sc = new Scanner(System.in);
		String Filepath = sc.nextLine();
		System.out.println(Filepath);
		
		sess.setFileSource(Filepath);
		System.out.println(sess.getFileSource());
		
		String[] path = {Filepath};
				
//		Program.inItMethodForThinClient(path);
		List<String> strurl = Program.inItMethodForThinClient(path);
		
		
//		try {
//			URL url = new URL(strurl.get(1));
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("GET");
//			con.setRequestProperty("Accept", "application/json");
//			
//			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			String response; // = in.lines().collect(Collectors.joining());
//			
//			while((response = in.readLine()) != null) {
//				System.out.println(response);
//				
//				
//			}
//			con.disconnect();
//			
//			JSONObject jObject  = new JSONObject();
//			JSONObject data = jObject.getJSONObject("data");
////			String jsonText = JSONValue.toJSONString(response);
//			System.out.println(data);
//			
//
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		String xmlPath = "C:\\\\PRI_FILE\\\\Practise File\\\\FileDemo\\\\XMLTextFile";	
		try {
			
//			File file = new File("xmlPath");														//To create file on given path
//			boolean result = file.createNewFile();
//			System.out.println("file created "+file.getCanonicalPath());
//			
//			Writer fileWriter = new FileWriter(xmlPath, false);
			
			
			URL url = new URL(strurl.get(0));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			String response; // = in.lines().collect(Collectors.joining());
//			
//			while((response = in.readLine()) != null) {
//				System.out.println(response);
//				fileWriter.write(response);
//				
//				
//			}
//			fileWriter.close();
			con.disconnect();
	

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		Map<Integer, String> textList = new HashMap<Integer, String>();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(strurl.get(0));
			NodeList lineList = doc.getElementsByTagName("line");
			for(int i=0; i<lineList.getLength();i++) {
				Node b = lineList.item(i);
				
//				if(b.getNodeType() == Node.ELEMENT_NODE) {
//					System.out.println(b.getTextContent());
//
//				}
//				System.out.println(b.getTextContent());
				String str = b.getTextContent().toString();
				String str2 = str.replaceAll("\n", "");
				textList.put(i, str2);
//				System.out.println(str2);
								
			}
			
			Set<Integer> key = textList.keySet();
			for(Integer k : key) {
				System.out.println(k + ":" + textList.get(k));
			}
			String jsonStr = JSONValue.toJSONString(textList);
			System.out.println(jsonStr);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
