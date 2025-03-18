plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "com.drianmr.common.validator"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinx.datetime)
}

tasks.test {
    useJUnitPlatform()
}
