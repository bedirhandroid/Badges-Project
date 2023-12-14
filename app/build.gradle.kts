plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs")
}

android {
    namespace = "com.bedirhandroid.badgesproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bedirhandroid.badgesproject"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.databinding:viewbinding:8.2.0")
    implementation("junit:junit:4.13.2")

    val navVersion = "2.7.5"
    val pagingVersion = "3.2.1"

    //PAGING
    implementation ("androidx.paging:paging-runtime-ktx:$pagingVersion")

    //HILT
    implementation ("com.google.dagger:hilt-android:2.49")
    kapt ("com.google.dagger:hilt-compiler:2.49")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.49")
    kaptAndroidTest ("com.google.dagger:hilt-compiler:2.49")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.49")
    kaptTest ("com.google.dagger:hilt-compiler:2.49")

    //NAV COMPONENT
    implementation ("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    // RETROFIT
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")

    //GSON
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //COROUTINE
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //GLIDE
    implementation ("com.github.bumptech.glide:glide:4.12.0")

    //LOTTIE
    implementation ("com.airbnb.android:lottie:5.0.3")

    //SERIALIZABLE
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    //MOCK
    testImplementation("io.mockk:mockk:1.12.0")

    //TEST
    implementation("androidx.arch.core:core-testing:2.2.0")
    implementation("io.mockk:mockk:1.12.0")
    implementation("app.cash.turbine:turbine:0.5.2")
    implementation("com.google.truth:truth:1.1.5")
    implementation("org.objenesis:objenesis:3.1")

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("androidx.test:runner:1.5.2")
    testImplementation("app.cash.turbine:turbine:0.5.2")
    testImplementation("com.google.truth:truth:1.1.5")

    androidTestImplementation("app.cash.turbine:turbine:0.5.2")
    androidTestImplementation("com.google.truth:truth:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}