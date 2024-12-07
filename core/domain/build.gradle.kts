plugins {
    alias(libs.plugins.composeTest.library)
}

android {
    namespace = "com.bbcnewschallenge.core.domain"
}

dependencies {
    implementation(projects.core.security)
    implementation(projects.common)
}