plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    // Dependencias de prueba
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    // Mocks
    testImplementation("org.mockito:mockito-core:5.4.0")
    testImplementation("org.mockito:mockito-inline:5.2.0")

    // RestAssured
    testImplementation("io.rest-assured:rest-assured:5.3.2")
    testImplementation("io.rest-assured:json-path:5.3.2")
    implementation("io.rest-assured:json-schema-validator:5.3.2")
    implementation("io.rest-assured:rest-assured-common:5.3.2")
    testImplementation("io.rest-assured:rest-assured-all:5.3.2")
    implementation("org.json:json:20230618")

    // Selenium WebDriver
    implementation("org.seleniumhq.selenium:selenium-java:4.14.0")

}

tasks.test {
    useJUnitPlatform()
}