package com.cpgmn.account;

import com.cpgmn.account.config.JpaConfig;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {
        "com.cpgmn.account",
        "com.cpgmn.account.service"
})
@SpringBootConfiguration
@EnableJpaRepositories(basePackages = {"com.cpgmn.account.repository"})
@Import({JpaConfig.class})
public class TestConfiguration {
}
