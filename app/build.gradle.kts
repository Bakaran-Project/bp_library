plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}


android {
    compileSdk =32
    defaultConfig {
        applicationId = Version.applicationId
        minSdk =21
        targetSdk =30
        versionCode =1
        versionName = "0.0.0(10)"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    lint {
        baseline = file("lint-baseline.xml")
        abortOnError =false
    }


    compileOptions {
        // Flag to enable support for the new language APIs
        isCoreLibraryDesugaringEnabled =true

        sourceCompatibility =JavaVersion.VERSION_1_8
        targetCompatibility =JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-alpha02"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/DEPENDENCIES"
        }
    }
}

dependencies {

    implementation (Libs.Com.Google.Android.Material.material)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation(Libs.AndroidX.Multidex.multidex)
    implementation(Libs.AndroidX.Core.coreKtx)
    implementation(Libs.AndroidX.Activity.activityCompose)
    with(Libs.AndroidX.Compose){
        implementation(Libs.AndroidX.Compose.Ui.ui)
        // https://stackoverflow.com/questions/68224361/jetpack-compose-cant-preview-after-updating-to-1-0-0-rc01
        implementation(Libs.AndroidX.Compose.Ui.uiTooling)
        implementation(Libs.AndroidX.Compose.Ui.uiToolingPreview)
        implementation(Libs.AndroidX.Compose.Material.material)
        implementation(Libs.AndroidX.Compose.Runtime.runtimeLivedata)
        androidTestImplementation(Libs.AndroidX.Compose.Ui.uiTestJunit4)
        debugImplementation(Libs.AndroidX.Compose.Ui.uiTestManifest)
        debugImplementation(Libs.AndroidX.Compose.Ui.uiTooling)
        androidTestImplementation(Libs.AndroidX.Compose.Ui.uiTestJunit4)

    }
    with(Libs.AndroidX.Lifecycle){
        implementation(lifecycleRuntimeKtx)
        // ViewModel
        implementation(lifecycleViewmodel)
        implementation(lifecycleLivedata)
        implementation(lifecycleRuntime)
        implementation(lifecycleViewmodelSavedstate)
    }

    testImplementation(Libs.AndroidX.Arch.Core.coreTesting)
    androidTestImplementation(Libs.AndroidX.Arch.Core.coreTesting)

    //hilt dagger (support viewModel)
    //https://developer.android.com/training/dependency-injection/hilt-android#setup
    //https://developer.android.com/training/dependency-injection/hilt-testing?hl=id
    with(Libs.Com.Google.Dagger){
        implementation(hiltAndroid)
        kapt(hiltAndroidCompiler)
        testImplementation(hiltAndroidTesting)
        kaptTest(hiltAndroidCompiler)
        androidTestImplementation(hiltAndroidTesting)
        kaptAndroidTest(hiltAndroidCompiler)

    }

    implementation(Libs.Com.Github.Jeziellago.composeMarkdown)

    testImplementation(Libs.Org.Mockito.mockitoCore)
    //  Bump to 4.6.* after https://github.com/robolectric/robolectric/issues/6593 is fixed
    testImplementation(Libs.Org.Robolectric.robolectric)

    //navigation
    //https://developer.android.com/jetpack/compose/navigation
    implementation(Libs.AndroidX.Navigation.navigationCompose)


    //supaya bisa inject viewModel ke navigation
    //https://developer.android.com/jetpack/compose/libraries#hilt
    implementation(Libs.AndroidX.Hilt.hiltNavigationCompose)

    with(Libs.AndroidX.Room){
        implementation(roomRuntime)
        implementation(roomPaging)
        implementation(roomKtx)
        kapt(roomCompiler)
        testImplementation(roomTesting)

    }

    //firebase
    with(Libs.Com.Google.Firebase){
        implementation(platform(bom))
        implementation(auth)
        implementation(firestore)
        implementation(storage)
        implementation(messaging)
        implementation(crashlytics)
        implementation(analytics)

    }
    //google auth
    with(Libs.Com.Google.Android.Gms){
        implementation(auth)
    }

    //allow use await() in firebase task
    with(Libs.Org.Jetbrains.Kotlinx){
        implementation(googlePlayKotlinCoroutine)
    }

    //logcat
    with(Libs.Com.Squareup.Logcat){
        implementation(logcat)
    }

    //retrofit
    with(Libs.Com.Squareup.Retrofit2){
        implementation(retrofit)
        implementation(gsonFactory)
    }
    //okhttp
    with(Libs.Com.Squareup.Okhttp3){
        implementation(okhttp)
        implementation(loggingInterceptor)
        implementation(mockWebServer)
    }

    //icon
    with(Libs.Br.Com.Devsrsouza.Compose.Icons.Android){
        implementation(octicons)
        implementation(feather)
    }
    
    //system ui controller
    with(Libs.Com.Google.Accompanist){
        implementation(accompanistSystemUiController)
        implementation(accompanistNavigationAnimation)
        implementation(accompanistPager)
        implementation(accompanistPagerIndicator)
    }
    //image loader
    with(Libs.Io.CoilKt){
        implementation(coilCompose)
    }

    //chart
    with(Libs.Com.Github.PhilJay){
        implementation(mpAndroidChart)
    }

    implementation(Libs.Com.Github.GrenderG.toasty)

    //local unit test
    testImplementation(Libs.Junit.junit)
    testImplementation(Libs.Com.Google.Truth.truth)
    androidTestImplementation(Libs.Com.Google.Truth.truth)

    //instrumentation test
    androidTestImplementation(Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation(Libs.AndroidX.Test.Espresso.espressoCore)
    androidTestImplementation(Libs.Org.Jetbrains.Kotlinx.kotlinxCoroutinesTest)


}


// Allow references to generated code
kapt {
    correctErrorTypes = true
}