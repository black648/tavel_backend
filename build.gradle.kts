import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	dependencies {
		classpath("gradle.plugin.com.ewerk.gradle.plugins:querydsl-plugin:1.0.10")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
		classpath("org.jetbrains.kotlin:kotlin-allopen:1.8.0")
		classpath("org.jetbrains.kotlin:kotlin-noarg:1.8.0")
	}
}

plugins {
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.0"
	kotlin("plugin.spring") version "1.8.0"
	kotlin("plugin.jpa") version "1.8.0"
	kotlin("kapt") version "1.8.0"
}

repositories {
	mavenCentral()
}

group = "com"
java.sourceCompatibility = JavaVersion.VERSION_17


allOpen {
	// Spring Boot 3.0.0
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

dependencies {
	// Spring Boot 3.0.0
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("com.vladmihalcea:hibernate-types-60:2.20.0")
	implementation("com.infobip:infobip-spring-data-jpa-querydsl-boot-starter:8.0.0")

	kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

	// DB
	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.mysql:mysql-connector-j")

	// JWT
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	// Swagger
	implementation("io.springfox:springfox-boot-starter:3.0.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-reflect:1.8.0")
}


//// Kotlin QClass Setting
//kotlin.sourceSets.main {
//    println("kotlin sourceSets builDir:: $buildDir")
//    setBuildDir("$buildDir")
//}

//idea {
//    module { val kaptMain = file("build/generated/source/kapt/main")
//        sourceDirs.add(kaptMain)
//        generatedSourceDirs.add(kaptMain) }
//}


tasks.withType<KotlinCompile> {
	kotlinOptions {
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}