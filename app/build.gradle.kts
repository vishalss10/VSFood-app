import org.gradle.kotlin.dsl.implementation as implementation1

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.vsfood"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.vsfood"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures  {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation1(libs.car.ui.lib)
    implementation1(libs.androidx.core.ktx)
    implementation1(libs.androidx.appcompat)
    implementation1(libs.material)
    implementation1(libs.androidx.activity)
    implementation1(libs.androidx.constraintlayout)
    implementation1(libs.support.annotations)
    implementation1(libs.androidx.navigation.fragment.ktx)
    implementation1(libs.androidx.navigation.ui.ktx)
    implementation1(libs.androidx.cardview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation1("com.github.denzcoskun:ImageSlideshow:0.1.0")

}