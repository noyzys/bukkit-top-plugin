import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "io.github.noyzys.top"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.4.21"
}

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("io.vavr:vavr-kotlin:0.10.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.+")

    compileOnly(files("C:/Users/opel3/Desktop/Depends/PaperSpigot-1.8.8-R0.1-SNAPSHOT-latest.jar"))
}

val compileKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    freeCompilerArgs = listOf("-Xinline-classes")
    jvmTarget = "1.8"
}

