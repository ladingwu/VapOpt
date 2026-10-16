plugins {
    alias(libs.plugins.proj.android.library)
    alias(libs.plugins.proj.android.library.jacoco)
}

android {
    namespace = "com.tencent.qgame.animplayer"
}

dependencies {
    implementation(libs.kotlin.bom)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
