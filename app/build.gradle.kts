plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.gms.google-services")
}

android {
    compileSdkVersion(ProjectProperties.compileSdk)

    defaultConfig {
        minSdkVersion(ProjectProperties.minSdk)
        targetSdkVersion(ProjectProperties.targetSdk)
        applicationId = BuildProperties.appId
        versionCode = BuildProperties.versionCode
        versionName = BuildProperties.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        named("debug") {
            storeFile(file("debug.jks"))
            storePassword("atomapp")
            keyAlias("atomapp")
            keyPassword("atomapp")
        }
    }

    buildTypes {
        getByName("release") {
            postprocessing {
                isObfuscate = true
                isOptimizeCode = true
                isRemoveUnusedCode = true
                proguardFiles("proguard-rules.pro")
            }
            signingConfig = signingConfigs.named("debug").get()
        }
        getByName("debug") {
            signingConfig = signingConfigs.named("debug").get()
        }
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.Kotlin.coroutines)

    implementation(Dependencies.AndroidX.core)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.Material.material)
    implementation(Dependencies.AndroidX.constraintLayout)
    implementation(Dependencies.AndroidX.activity)
    implementation(Dependencies.AndroidX.fragment)

    implementation(Dependencies.AndroidX.Navigation.navigation)
    implementation(Dependencies.AndroidX.Navigation.navigationUi)

    implementation(Dependencies.AndroidX.Lifecycle.viewModel)
    implementation(Dependencies.AndroidX.Lifecycle.liveData)

    implementation(Dependencies.Dagger.dagger)
    kapt(Dependencies.Dagger.daggerCompiler)

    implementation(platform(Dependencies.Firebase.bom))
    implementation(Dependencies.Firebase.auth)
    implementation(Dependencies.Gms.auth)

    testImplementation(Dependencies.Testing.junit)
    androidTestImplementation(Dependencies.Testing.androidXJunit)
    androidTestImplementation(Dependencies.Testing.espresso)
}