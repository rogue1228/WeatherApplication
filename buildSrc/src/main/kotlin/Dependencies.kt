/**
 * Created by JunhwaLee on 2021-05-28
 */

object Versions {
    const val kotlinVersions = "1.5.0"
    const val rxJava3Versions = "3.0.0"
    const val retrofitVersions = "2.9.0"
    const val chunkVersions = "3.4.0"
    const val koin = "2.2.2"
    const val glide = "4.12.0"
    const val swipeRefreshLayout = "1.1.0"
    const val paging = "3.0.0"
    const val navigation = "2.3.5"
    const val lifecycle = "2.3.1"
    const val jetPack = "1.3.2"
    const val appCompat = "1.2.0"
    const val material = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val vectorDrawable = "1.1.0"

    const val gson = "2.8.7"

    const val junit = "4.+"
    const val androidJunit = "1.1.2"
    const val espresso = "3.3.0"
}

object Deps {
    // kotlin lib
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersions}"
    const val kotlinSTDLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersions}"

    // jetpack lib
    const val jetPackCore = "androidx.core:core-ktx:${Versions.jetPack}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    const val material = "com.google.android.material:material:${Versions.material}"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    // rx lib
    const val rxJava3 = "io.reactivex.rxjava3:rxjava:${Versions.rxJava3Versions}"
    const val rxAndroid3 = "io.reactivex.rxjava3:rxandroid:${Versions.rxJava3Versions}"

    // retrofit lib
    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersions}"
    const val retrofit2RxJavaAdapter =
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofitVersions}"
    const val retrofit2GsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersions}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // glide lib
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // network monitor lib
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chunkVersions}"

    // unit test lib
    const val testKotlinJDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersions}"
    const val testKotlin = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlinVersions}"
    const val testKotlinJunit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinVersions}"
    const val testJunit = "junit:junit:${Versions.junit}"
    const val testAndroidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val testEspresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object BuildConfig {
    const val BASE_API_URL = "https://www.metaweather.com/"
}

object BuildVersions {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"

    const val minSdkVersion = 23
    const val targetSdkVersion = 30

}