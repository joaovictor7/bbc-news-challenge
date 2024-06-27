plugins {
    alias(libs.plugins.composeTest.library)
}

android {
    namespace = "com.composetest.core.data"
}

dependencies {
    implementation(projects.common)
    implementation(projects.core.database)
    implementation(libs.androidx.dataStore)
    implementation(libs.androidx.hilt.work)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.negotiation)
    implementation(libs.ktor.client.serialization)
    implementation(libs.ktor.client.logging)
    implementation(libs.androidx.workManager)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    api(libs.firebase.auth)
    ksp(libs.androidx.hilt.compiler)
}