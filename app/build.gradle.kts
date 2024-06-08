plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.example.m017_recyclerview"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.m017_recyclerview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:3.11.0")
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    kapt("com.github.bumptech.glide:compiler:4.14.2")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.moshi:moshi:1.14.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.4.0")
    implementation ("androidx.fragment:fragment-ktx:1.5.6")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    val paging_version = "3.3.0"

    implementation("androidx.paging:paging-runtime:$paging_version")

    // alternatively - without Android dependencies for tests
    testImplementation("androidx.paging:paging-common:$paging_version")

    // optional - RxJava2 support
    implementation("androidx.paging:paging-rxjava2:$paging_version")

    // optional - RxJava3 support
    implementation("androidx.paging:paging-rxjava3:$paging_version")

    // optional - Guava ListenableFuture support
    implementation("androidx.paging:paging-guava:$paging_version")

    // optional - Jetpack Compose integration
    implementation("androidx.paging:paging-compose:3.3.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}