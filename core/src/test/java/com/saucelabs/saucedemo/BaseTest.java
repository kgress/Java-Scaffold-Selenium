package com.saucelabs.saucedemo;

import com.saucelabs.saucedemo.environment.EnvironmentConfig;
import io.github.kgress.scaffold.ScaffoldBaseTest;
import io.github.kgress.scaffold.environment.config.ScaffoldConfiguration;
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
        classes = { EnvironmentConfig.class, ScaffoldConfiguration.class }
)
public abstract class BaseTest extends ScaffoldBaseTest {

    // Shared constant variables that are used in the LoginTest and InventoryTest files
    protected static final String USERNAME = "standard_user";
    protected static final String PASSWORD = "secret_sauce";

    @Autowired
    protected Navigation navigation;
}