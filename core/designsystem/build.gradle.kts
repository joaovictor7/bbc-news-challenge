plugins {
    alias(libs.plugins.composeTest.library)
    alias(libs.plugins.composeTest.compose)
}

android {
    namespace = "com.bbcnewschallenge.core.designsystem"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.domain)
}