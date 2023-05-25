plugins {
    kotlin("jvm") version "1.7.0"
    application
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "io.lexylynx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.0")

    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.slf4j:jul-to-slf4j")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.xerial:sqlite-jdbc:3.36.0")

    // OPen AI kotlin
    //    implementation("com.aallam.openai:openai-client:3.2.4")
    // Unit test
    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    testImplementation("org.mockito:mockito-core:5.2.0")
    // Spring Boot Test dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.test {
    useJUnitPlatform()
}


application {
    mainClass.set("MainKt")
}