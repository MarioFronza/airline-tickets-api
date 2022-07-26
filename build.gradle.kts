import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val okhttp3_version: String by project
val mockk_version: String by project

plugins {
    kotlin("jvm") version "1.7.0"
}

group = "com.github"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:$okhttp3_version")

    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:$mockk_version")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}