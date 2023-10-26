package com.rainbow.autoconfig;

import com.example.EnableHeaderConfig;
import com.example.UtilsImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan({"com.rainbow", "com.example"})
//@Import(value = TokenParser.class)
//@Import(HeaderConfig.class)
//@Import(UtilsImportSelector.class)
@EnableHeaderConfig
@SpringBootApplication
public class SpringbootAutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAutoconfigApplication.class, args);
    }

}
