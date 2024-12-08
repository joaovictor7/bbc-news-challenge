plugins {
    alias(libs.plugins.composeTest.library)
    alias(libs.plugins.composeTest.test)
}

android {
    namespace = "com.bbcnewschallenge.core.domain"
}

dependencies {
    implementation(projects.core.security)
    implementation(projects.common)
}