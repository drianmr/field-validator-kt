import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
    `maven-publish`
}

group = "com.drianmr.common"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinx.datetime)
}

tasks.test {
    useJUnitPlatform()
}

java {
    withSourcesJar()
}

mavenPublishing {
    configure(
        KotlinJvm(
            // configures the -javadoc artifact, possible values:
            // - `JavadocJar.None()` don't publish this artifact
            // - `JavadocJar.Empty()` publish an emprt jar
            // - `JavadocJar.Dokka("dokkaHtml")` when using Kotlin with Dokka, where `dokkaHtml` is the name of the Dokka task that should be used as input
            javadocJar = JavadocJar.Dokka("dokkaHtml"),
            // whether to publish a sources jar
            sourcesJar = true,
        )
    )
    // publishToMavenCentral(SonatypeHost.DEFAULT)
    // or when publishing to https://s01.oss.sonatype.org
    // publishToMavenCentral(SonatypeHost.S01)
    // or when publishing to https://central.sonatype.com/
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates("io.github.drianmr", "field-validator-kt", "1.0.0")

    pom {
        name.set("Field Validator")
        description.set("Validator for field input")
        inceptionYear.set("2025")
        url.set("https://github.com/drianmr/field-validator-kt")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/license/mit")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("drianmr")
                name.set("Adrian M. R.")
                url.set("https://github.com/drianmr/")
            }
        }
        scm {
            url.set("https://github.com/drianmr/field-validator-kt/")
            connection.set("scm:git:git://github.com/drianmr/field-validator-kt.git")
            developerConnection.set("scm:git:ssh://git@github.com/drianmr/field-validator-kt.git")
        }
    }
}
