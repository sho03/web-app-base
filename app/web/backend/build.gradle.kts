import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"

	// flyway
	id("org.flywaydb.flyway") version "9.0.0"
}

group = "sho03"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// flyway migration
	implementation("org.flywaydb:flyway-core:9.0.0")
	runtimeOnly("org.flywaydb:flyway-mysql:9.0.0")
	implementation("mysql:mysql-connector-java:8.0.33")
}

flyway {
	url = "jdbc:mysql://127.0.0.1:3306/exampledb"
	user = "user"
	password = "password"
	locations = arrayOf("filesystem:db/migration")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
