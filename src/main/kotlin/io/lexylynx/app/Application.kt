package io.lexylynx.app

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = ["io.lexylynx.controller",
    "io.lexylynx.service",
    "io.lexylynx.model",
    "io.lexylynx.repository",
    "io.lexylynx.accessor",
    "io.lexylynx.utils"])
open class Application