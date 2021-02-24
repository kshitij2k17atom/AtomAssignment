object Dependencies {
    object Gradle {
        const val kotlinPlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${ProjectProperties.kotlinVersion}"
        const val androidPlugin = "com.android.tools.build:gradle:${ProjectProperties.agp}"
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${ProjectProperties.kotlinVersion}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2"
    }

    object AndroidX {
        const val core = "androidx.core:core-ktx:1.3.2"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val fragment = "androidx.fragment:fragment-ktx:1.3.0"
        const val activity = "androidx.activity:activity-ktx:1.2.0"

        object Lifecycle {
            private const val lifecycleVersion = "2.3.0"

            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
        }

        object Navigation {
            private const val navVersion = "2.3.3"

            const val navigation = "androidx.navigation:navigation-fragment-ktx:$navVersion"
            const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navVersion"
            const val safeArgs =
                "androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion"
        }
    }

    object Dagger {
        private const val daggerVersion = "2.32"

        const val dagger = "com.google.dagger:dagger:$daggerVersion"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
    }

    object Material {
        const val material = "com.google.android.material:material:1.2.1"
    }

    object Testing {
        const val junit = "junit:junit:4.+"
        const val androidXJunit = "androidx.test.ext:junit:1.1.2"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
    }

    object Gms {
        const val gms = "com.google.gms:google-services:4.3.5"
        const val auth = "com.google.android.gms:play-services-auth:19.0.0"
    }

    object Firebase {
        const val bom = "com.google.firebase:firebase-bom:26.5.0"
        const val auth = "com.google.firebase:firebase-auth"
    }
}