object Dependencies {
    object Gradle {
        const val kotlinPlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${ProjectProperties.kotlinVersion}"
        const val androidPlugin = "com.android.tools.build:gradle:${ProjectProperties.agp}"
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${ProjectProperties.kotlinVersion}"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.3.2"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    }

    object Material {
        const val material = "com.google.android.material:material:1.2.1"
    }

    object Testing {
        const val junit = "junit:junit:4.+"
        const val androidXJunit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object Firebase {
        const val gms = "com.google.gms:google-services:4.3.5"
        const val bom = "com.google.firebase:firebase-bom:26.5.0"
    }
}