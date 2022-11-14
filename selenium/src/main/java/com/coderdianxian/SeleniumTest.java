package com.coderdianxian;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: SeleniumTest
 * @Description: selenium绕过淘宝反爬机制登录
 * @Author:coderDianxia
 * @Date: 2022/11/10 9:46
 */
public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException, IOException, ExecutionException {

        //下载对应浏览器驱动地址。https://www.selenium.dev/zh-cn/documentation/webdriver/getting_started/install_drivers/
        //选择跟自己浏览器相近的版本的驱动，这里选择google的107.0.5304.62版本
        String path = "selenium/src/main/resources/chromedriver.exe";
        File file=new File(path);
        if(file.exists()) {
            System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
        }else{
            System.out.println("查找不到驱动地址");
            System.exit(1);
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        // 开启实验性功能
        chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        //去除特征值
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");


        WebDriver webDriver = new ChromeDriver(chromeOptions);

        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("虚拟机关闭执行webDriver退出");
            webDriver.quit();
        }));
        //在每个Frame 刚刚打开，还没有运行 Frame 的脚本前，运行给定的脚本。即在加载网页的js脚本前加载
        //将window.navigator.webdriver设置为undefined
        /**
         * Object.defineProperty(navigator, 'webdriver', {
         *       get: () => undefined
         *     })
         */
        String script="Object.defineProperty(navigator, 'webdriver', {\n" +
                "      get: () => undefined\n" +
                "    })";
        HashMap<String, Object> map = new HashMap<>();
        map.put("source",script);
        ChromeDriver webDriver1 = (ChromeDriver) webDriver;
        webDriver1.executeCdpCommand("Page.addScriptToEvaluateOnNewDocument",map);
        //导航到浏览器
        webDriver.get("https://www.tmall.com");

        /**
         * 发送命令 查找元素
         * 大多数Selenium会话中的主要命令都与元素相关, 如果不先找到元素, 就无法与之交互
         *
         */
        WebElement login = webDriver.findElement(By.className("sn-login"));
        login.click();
//        //建立等待策略
//        /**
//         * 将代码与浏览器的当前状态同步 是Selenium面临的最大挑战之一, 做好它是一个高级主题.
//         *
//         * 基本上, 您希望在尝试定位元素之前, 确保该元素位于页面上, 并且在尝试与该元素交互之前, 该元素处于可交互状态.
//         *
//         * 隐式等待很少是最好的解决方案, 但在这里最容易演示, 所以我们将使用它作为占位符.
//         */
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
//        //密码登录
        WebElement account = webDriver.findElement(By.name("fm-login-id"));
        WebElement password = webDriver.findElement(By.name("fm-login-password"));
        WebElement submitButton = webDriver.findElement(By.tagName("button"));

//        //输入淘宝账号
        account.sendKeys("");
//        //淘宝密码
        password.sendKeys("");

        submitButton.click();

        while(true){
            System.out.println("====");
        }
    }
}
