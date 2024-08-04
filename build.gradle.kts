// Declare Kotlin version as a constant for better readability and maintainability
const val KOTLIN_VERSION = "2.5.0"

buildscript {
    // Use the constant for consistency
    ext.kotlin_version = KOTLIN_VERSION

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        // Use the constant here as well
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION")

        // Firebase - Consider grouping related dependencies for better organization
        classpath("com.google.gms:google-services:4.3.10")
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.7.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Clean task - No changes needed, looks good!
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// Plugins - Consider moving this block to the top of the file,
// as plugins are usually declared before dependencies
plugins {
    id("com.google.gms.google-services") version "4.4.2" apply false
}