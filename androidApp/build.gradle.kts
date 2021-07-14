import util.getLocalProperty

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    kotlin("plugin.serialization")
    id("com.google.gms.google-services")
}

val hasReleaseKey: Boolean = project.rootProject.file("release/yaba-release.jks").exists()

dependencies {
    implementation(project(":shared"))
    implementation("androidx.core:core-ktx:1.7.0-alpha01")
    implementation("androidx.appcompat:appcompat:1.4.0-alpha03")
    implementation("com.google.android.material:material:1.4.0")
    implementation(Lib.Compose.animation)
    implementation(Lib.Compose.foundation)
    implementation(Lib.Compose.layout)
    implementation(Lib.Compose.iconsExtended)
    implementation(Lib.Compose.material)
    implementation(Lib.Compose.runtime)
    implementation(Lib.Compose.tooling)
    implementation(Lib.Compose.ui)
//    implementation(Lib.Compose.preview)

    implementation(platform(Lib.KotlinX.Coroutines.bom))
    implementation(Lib.KotlinX.Coroutines.core)
    implementation(Lib.KotlinX.Coroutines.android)
    implementation(Lib.Koin.core)
    implementation(Lib.Koin.android)
    implementation(Lib.Koin.compose)
    implementation(Lib.kermit)
    implementation(Lib.KotlinX.dateTime)
    implementation(Lib.KotlinX.Serialization.json)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha02")
    implementation("androidx.activity:activity-compose:1.3.0-rc01")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha04")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha08")
    implementation("com.plaid.link:sdk-core:3.4.0")
    implementation(Lib.Accompanist.coil)
    implementation(Lib.Accompanist.insets)
    implementation(Lib.Accompanist.insetsUi)
    implementation(Lib.uuid)
    implementation(platform(Lib.Firebase.bom))
    implementation(Lib.Firebase.analytics)
    implementation(Lib.Firebase.cloudMessaging)
    implementation(Lib.Firebase.messagingDirectBoot)
    implementation(Lib.Jetpack.work)
    implementation(Lib.Jetpack.workMultiProcess)
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"
    defaultConfig {
        applicationId = "tech.alexib.yaba"
        minSdk = 29
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        manifestPlaceholders["serverUrl"] = "\"https://yabasandbox.alexib.dev/graphql\""
    }

    signingConfigs {
        register("release")
        getByName("debug") {
            storeFile = rootProject.file("release/debug.jks")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }
    if (hasReleaseKey) {
        signingConfigs["release"].apply {
            keyAlias(getLocalProperty("yaba.key.alias"))
            keyPassword(getLocalProperty("yaba.key.password"))
            storePassword(getLocalProperty("yaba.store.password"))
            storeFile(rootProject.file("release/yaba-release.jks"))
        }
    }
    buildTypes {
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig =
                if (hasReleaseKey) signingConfigs.getByName("release") else
                    signingConfigs.getByName("debug")
        }
        debug {
            isMinifyEnabled = false
            isDebuggable = true
            matchingFallbacks += "release"
            signingConfig = signingConfigs.getByName("debug")
        }
        create("staging") {
            initWith(getByName("debug"))
            manifestPlaceholders["serverUrl"] = "\"https://ruffrevival.ngrok.io/graphql\""
        }
    }
    flavorDimensions.add("environment")

    productFlavors {
        create("dev") {
            dimension = "environment"
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
        }
        create("sandbox") {
            isDefault = true
            dimension = "environment"
            applicationIdSuffix = ".sandbox"
            versionNameSuffix = "-sandbox"
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Version.compose
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xskip-prerelease-check",
            "-Xuse-experimental=kotlin.Experimental",
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-Xuse-experimental=kotlinx.coroutines.FlowPreview",
            "-Xuse-experimental=kotlin.ExperimentalStdlibApi",
            "-Xuse-experimental=androidx.compose.foundation.ExperimentalFoundationApi",
            "-Xuse-experimental=androidx.compose.material.ExperimentalMaterialApi",
            "-Xuse-experimental=androidx.compose.animation.ExperimentalAnimationApi",
            "-Xuse-experimental=kotlin.time.ExperimentalTime",
            "-Xuse-experimental=androidx.compose.ui.ExperimentalComposeUiApi"
        )
    }
    packagingOptions {
        resources {
            excludes.add("META-INF/*.version")
            excludes.add("META-INF/proguard/*")
            excludes.add("/*.properties")
            excludes.add("fabric/*.properties")
            excludes.add("META-INF/*.properties")
        }
    }
    lint {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
        isAbortOnError = false
    }
    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}
