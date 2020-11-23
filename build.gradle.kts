import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
}

buildscript {
	repositories {
		mavenCentral()
		maven(url = "https://plugins.gradle.org/m2/")
	}

	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-allopen:1.4.10")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
		classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.10")
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.4.0")
	}
}

//java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {

	apply(plugin = "java")
	apply(plugin = "kotlin")
	apply(plugin = "kotlin-spring")
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")

	group = "allen.lee"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-rsocket")
		implementation("org.springframework.boot:spring-boot-starter-webflux")
		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		implementation("io.reactivex.rxjava3:rxjava:3.0.7")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("io.projectreactor:reactor-test")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}
}

