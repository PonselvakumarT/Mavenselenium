package test.Selenium;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadProperties {
	
	//String filepath = "C:\\Users\\SathyaLakshmi\\Desktop\\Selenium\\selenium.properties";

	//public void readProperty()throws IOException {

	public static void main(String[] args) throws IOException {

	
	File F = new File("C:\\Users\\SathyaLakshmi\\Desktop\\Selenium\\selenium.properties");
	FileInputStream FS = new FileInputStream(F);
	Properties p = new Properties();
	p.load(FS);
	String actualName = p.getProperty("name");
	System.out.println(actualName);


	//PropertyFile P = new PropertyFile();
	//P.readProperty();

		}

	}

//}