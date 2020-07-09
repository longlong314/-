import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.util.List;


public class test {
    public WebElement username;

    public static void main(String[] args) throws InterruptedException {

       System.setProperty("webdriver.chrome.driver","F://selenium//selenium3.0//chromedriver_win32//chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.get("http://www.xinshangmeng.com");

       Thread.sleep(1000);


       driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("用户名");

       driver.findElement(By.xpath("//*[@id=\"mcmm\"]")).sendKeys("密码");

       driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();

       Thread.sleep(1000);

       driver.findElement(By.xpath("//*[@id=\"qd-easy-order\"]")).click();

       Thread.sleep(6000);


        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            if (winHandle.equals(winHandleBefore)) {
                continue;
            }
            driver.switchTo().window(winHandle);
            break;
        }

        /*driver.findElement(By.xpath("//*[@id=\"req_qty_6901028077323A\"]")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"req_span_6901028080224\"]/span/em[2]")).click();*/




        List<WebElement> lw = driver.findElements(By.className("xsm-order-list-shuru-input"));
        for (WebElement lws:lw){
            if(lws.getAttribute("class").equals("20")){
                System.out.print("已经输入");
            }else{
                lws.sendKeys("20");
            }
        }


        //*[@id="req_span_6901028077323A"]/span/em[2]
        /*System.out.println(lw.size());
        for (WebElement webElement : lw) {
//           获取input输入框 属性id、name、Class 和文本框的值
            System.out.println(webElement.getAttribute("id")+" | "+ webElement.getAttribute("name")+" | "
                    +webElement.getAttribute("class")+" | " +webElement.getText().toString());

            //*[@id="req_span_6901028077323A"]/span/em[2]
            //*[@id=req_span_6901028077323A]/span/em[2]
        }*/



    }
}
