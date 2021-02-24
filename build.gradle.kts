buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Dependencies.Gradle.androidPlugin)
        classpath(Dependencies.Gradle.kotlinPlugin)
        classpath(Dependencies.Firebase.gms)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}