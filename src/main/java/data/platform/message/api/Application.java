package data.platform.message.api;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application
 *
 * @author zengsong
 * @version 1.0
 * @description TODO
 * @date 2018/12/28 15:10
 **/
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app =new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
