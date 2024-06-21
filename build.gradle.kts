plugins {
    id("java")
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.platzi"
version = "1.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

val webmvcUiVer = "2.5.0"
val lombokVer = "1.18.32"
val postgresqlVer = "42.7.3"
val mapstructVer = "1.5.5.Final"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") // no version, spring handle by default
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // no version, spring handle by default
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$webmvcUiVer") // API DOCUMENTATION: https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui

    compileOnly("org.projectlombok:lombok:$lombokVer") // LOMBOK ANOTATIONS: https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.mapstruct:mapstruct:$mapstructVer") // MAPPER: https://mvnrepository.com/artifact/org.mapstruct/mapstruct
    annotationProcessor("org.projectlombok:lombok:$lombokVer") // LOMBOK ANOTATIONS: https://mvnrepository.com/artifact/org.projectlombok/lombok
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVer") // MAPPER: https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor

    runtimeOnly("org.postgresql:postgresql:$postgresqlVer") // DB CONFIG: https://mvnrepository.com/artifact/org.postgresql/postgresql

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    jvmArgs("-XX:+EnableDynamicAgentLoading") // Supress test warning "A Java agent (byte-buddy-agent) has been loaded dynamically. Dynamic loading of agents will be disallowed by default in future releases"
}
