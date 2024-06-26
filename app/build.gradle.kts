plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlinAndroidKsp)
    alias(libs.plugins.hiltAndroid)

}

android {
    namespace = "com.morozov.testtaskforviesure"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.morozov.testtaskforviesure"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.core.ktx)
    implementation(libs.androidx.junit.ktx)
    implementation(libs.androidx.navigation.testing)
    implementation(project(":сommon"))
    implementation(project(":room"))
    implementation(project(":domain"))
    implementation(project(":network"))
    implementation(project(":navigation"))
    implementation(libs.androidx.media3.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //serialization
    implementation(libs.kotlinx.serialization.json)
    //hilt
    api (libs.hilt.android)
    api(libs.hilt.compose.navigation)
    ksp(libs.dagger.compiler)
    ksp(libs.hilt.compiler)
    //coil
    implementation(libs.coil)

    //refresher
     implementation(libs.pullrefresh)
    //timber
    implementation(libs.timber)

    testImplementation(libs.testmockito.core)
    testImplementation(libs.testmockito.kotlin)
    testImplementation(libs.testmockito.release)
    testImplementation(libs.testmockito.inline)

    testImplementation(libs.testcore.testing)
    testImplementation(libs.testcoroutines.test)
    testImplementation(libs.mockk)

}