package selenium2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



class Dogs {
	String img;

	public Dogs(String img) {
		super();
		this.img = img;
	}
	
	public void save() throws IOException {
		
		if (img.split(",").length <= 1) {
			return; 
		}
		
		String base64 = "";
		base64 = img.split(",")[1];

		String uuid = UUID.randomUUID().toString();
		String fileName = "";
		
		if (img.split(",")[0].indexOf("jpeg") > -1) {
			fileName = uuid + ".jpg";
		}else if(img.split(",")[0].indexOf("png") > -1) {
			fileName = uuid + ".png";
		}else if(img.split(",")[0].indexOf("gif") > -1) {
			fileName = uuid + ".gif";
		}
		
		
		
		byte[] imgByte = Base64.getDecoder().decode(base64);
		
		OutputStream os = new FileOutputStream("img/"+fileName);
		os.write(imgByte);
		os.close();
	}
	
}



public class selenium3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/search?newwindow=1&sca_esv=2c9182675fadbcab&hl=ko&sxsrf=AHTn8zoPVvkxv7GZbzpCk6yqhatdiZOyIA:1747808437772&q=%EA%B0%95%EC%95%84%EC%A7%80&udm=2&fbs=ABzOT_CZsxZeNKUEEOfuRMhc2yCI6hbTw9MNVwGCzBkHjFwaK6Wwr2U3Otxxdo7bek3qh0jM1D_pZCsNckRgN6AmwjZfmST0m_jvGek5FeiJmDC0zcKiMp0KimAcWcHBSIgWzKBsEtsn-3YCXXmuOEiA3QqOVmOs0UtF884YwNfHR4Y1goaqReiUNau8OEz0HIN0vDtwbqcfIEOTKcov-hTh4M_vK_XQ5__R-rOjVT7_Gv09eVYR3zw&sa=X&ved=2ahUKEwiqnsbo9bONAxU0sVYBHdtpBW8QtKgLegQIFBAB&cshid=1747808442717855&biw=558&bih=673&dpr=1");
		System.out.println(driver.getTitle());		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		WebElement div = driver.findElement(By.cssSelector(".MjjYud"));
		
		List<WebElement> we = div.findElements(By.cssSelector(".ob5Hkd"));
		
		for (WebElement webElement : we) {
			
			List<WebElement> imgList = webElement.findElements(By.cssSelector("img"));
			
			int i = 0;
			for (WebElement img : imgList) {
				Dogs dog = new Dogs(img.getDomAttribute("src"));
				try {
					dog.save();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					TimeUnit.SECONDS.sleep((long) 0.2);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(img.getDomAttribute("src"));
				i++;
				if (i == 10) {
					break;
				}
				
				
			}
		}
		
		
		driver.quit();

	}
	
	

}
