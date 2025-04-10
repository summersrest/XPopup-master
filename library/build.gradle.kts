plugins {
    id("com.android.library")
    id("maven-publish")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lxj.xpopup"
    compileSdk = 34

    defaultConfig {
        minSdk = 27
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.davemorrissey.labs:subsampling-scale-image-view-androidx:3.10.0")
    annotationProcessor("androidx.lifecycle:lifecycle-compiler:2.3.1")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.android.library"
            artifactId = "xpopup"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
