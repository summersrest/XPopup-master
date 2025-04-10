plugins {
    id("com.android.application")
}

android {
    namespace = "com.lxj.xpopupdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lxj.xpopupdemo"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

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


}

dependencies {
//    implementation 'com.github.li-xiaojun:StateLayout:1.3.4'
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.blankj:utilcodex:1.31.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.umeng.umsdk:common:9.4.4")
    implementation("com.umeng.umsdk:asms:1.4.1")
    implementation("com.umeng.umsdk:apm:1.5.2")
    implementation(project(mapOf("path" to ":library")))
//    implementation "androidx.viewpager2:viewpager2:1.0.0"
//    implementation 'com.github.li-xiaojun:XPopup:2.9.0'
//    implementation 'io.github.li-xiaojun:xpopup:2.9.4'

}

