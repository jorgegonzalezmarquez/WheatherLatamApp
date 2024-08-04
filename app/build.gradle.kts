apply plugin: "com.android.application"
apply plugin = "kotlin-android")
apply plugin: "kotlin-android-extensions"
apply plugin: "com.google.gms.google-services"
apply plugin: "com.google.firebase.firebase-crashlytics"

android {
    compileSDK = 32

    defaultConfig {
        applicationId = "com.example.weatherlatamapp"
        minSDK = 25
        targetSDK = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
                signingConfig  signingConfigs.qa
            )
        }
    }

    flavorDimensions "version"
    productFlavors {
        dev {
            dimension = "version"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            buildConfigField("String", "ENVIRONMENT", "\"dev\"")
        }

        qa {
            dimension = "version"
            applicationIdSuffix = ".qa"
            versionNameSuffix = "-qa"
            buildConfigField("String", "ENVIRONMENT", "\"qa\"")
            signingConfig signingConfigs.qa
        }

        prod {
            dimension = "version"
            buildConfigField("String", "ENVIRONMENT", "\"prod\"")
            signingConfig signingConfigs.prod
        }
    }
}

ext {
    kotlin_version = "1.8.0" // Update to the latest stable version
    androidx_core_version = "1.9.0" // Update to the latest stable version
    appcompat_version = "1.5.1" // Update to the latest stable version
    material_version = "1.7.0" // Update to the latest stable version
    constraintlayout_version = "2.1.4" // Update to the latest stable version
    firebase_crashlytics_version = "18.3.2" // Update to the latest stable version
    firebase_analytics_version = "21.2.0" // Update to the latest stable version
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.firebase.crashlytics.ktx)
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation "androidx.core:core-ktx:$androidx_core_version"
    implementation "androidx.appcompat:appcompat:$appcompat_version"
    implementation "com.google.android.material:material:$material_version"
    implementation "androidx.constraintlayout:constraintlayout:$constraintlayout_version"
    implementation "com.google.firebase:firebase-crashlytics:$firebase_crashlytics_version"
    implementation "com.google.firebase:firebase-analytics:$firebase_analytics_version"
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-analytics")
    }
apply plugin : "com.google.gms.google-services"
apply plugin : "com.google.firebase.firebase-crashlytics"

android {
    qa {
        keyAlias "weatherlatam_qa"
        keyPassword "your_key_password"
        storeFile file ("path/to/weatherlatam.jks")
        storePassword "your_store_password"
    }
    prod {
        keyAlias "weatherlatam_prod"
        keyPassword "your_key_password"
        storeFile file ("path/to/weatherlatam.jks")
        storePassword "your_store_password"
    }
}
plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

