import org.openqa.selenium.chrome.ChromeDriver

driver = {
    File file = new File("C:/Users/Arthur/Desktop/grails-cucumber-example/chromedriver.exe");
    System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
    new ChromeDriver();
}

baseUrl = "http://localhost:8080/"