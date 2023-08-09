plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //implementation("org.junit.jupiter:junit-jupiter-migration-support:5.0.0-M4")
    //implementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    //implementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    //implementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    //implementation("org.junit.jupiter:junit-jupiter-migrationsupport:5.9.2")
    //testImplementation(platform("org.junit:junit-bom:5.9.1"))
    //testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    //testImplementation("junit:junit:5.9.1")
    testImplementation("org.junit.jupiter:junit-jupiter-migration-support:5.0.0-M4")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-migrationsupport:5.9.2")

}

tasks.test {
    useJUnitPlatform()
}