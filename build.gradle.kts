plugins {
    id("java")
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.platzi"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

val dotEnvVer = "3.0.0"
val lombokVer = "1.18.32"
val postgresqlVer = "42.7.3"
val mapstructVer = "1.5.5.Final"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") // no version, spring handle by default
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // no version, spring handle by default
    implementation("io.github.cdimascio:dotenv-java:$dotEnvVer") // https://mvnrepository.com/artifact/io.github.cdimascio/dotenv-java

    compileOnly("org.projectlombok:lombok:$lombokVer") // https://mvnrepository.com/artifact/org.projectlombok/lombok
    annotationProcessor("org.projectlombok:lombok:$lombokVer")

    compileOnly("org.mapstruct:mapstruct:$mapstructVer") // https://mvnrepository.com/artifact/org.mapstruct/mapstruct
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVer") // https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor

    runtimeOnly("org.postgresql:postgresql:$postgresqlVer") // https://mvnrepository.com/artifact/org.postgresql/postgresql

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
