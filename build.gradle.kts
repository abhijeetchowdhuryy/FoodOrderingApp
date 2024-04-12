import java.util.Properties
import java.io.FileInputStream

buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.1")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
}
allprojects {
    repositories {
        google()
        jcenter()
        val githubProperties = Properties()
        githubProperties.load(FileInputStream(rootProject.file("github.properties")))
        repositories {
            maven {
                name = "GitHubPackages"

                url = uri("https://maven.pkg.github.com/Cuberto/liquid-swipe-android")
                credentials {
                    /** Create github.properties in root project folder file with
                     ** gpr.usr=GITHUB_USER_ID & gpr.key=PERSONAL_ACCESS_TOKEN
                     ** Or set env variable GPR_USER & GPR_API_KEY if not adding a properties file**/
                    username = githubProperties.getProperty("gpr.usr") ?: System.getenv("GPR_USER")
                    password = githubProperties.getProperty("gpr.key") ?: System.getenv("GPR_API_KEY")
                }
            }
        }
    }
}
