import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    application
    groovy
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven { url = uri("https://maven.aliyun.com/repository/jcenter") }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    implementation(localGroovy())
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}