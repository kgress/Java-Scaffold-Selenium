package com.saucelabs.saucedemo;

import com.retailmenot.scaffold.environment.config.ScaffoldConfiguration;
import com.retailmenot.scaffold.webdriver.ScaffoldBaseTest;
import com.saucelabs.saucedemo.environment.SauceDemoConfig;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(SpringExtension.class)
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.NONE,
    classes = { SauceDemoConfig.class, ScaffoldConfiguration.class }
)
public abstract class BaseTest extends ScaffoldBaseTest {
    @Autowired
    protected SauceDemoNavigation navigation;

    @AfterEach
    protected void setTestStatus() {
        //set test status
    }
}