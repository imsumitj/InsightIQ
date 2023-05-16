package io.lexylynx.app

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["io.lexylynx.controller",
    "io.lexylynx.service",
    "io.lexylynx.model",
    "io.lexylynx.repository"])
open class Application