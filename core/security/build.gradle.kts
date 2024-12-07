plugins {
    alias(libs.plugins.composeTest.library)
}

android {
    namespace = "com.bbcnewschallenge.core.security"
}

dependencies {
    implementation(libs.sql.cipher)
    implementation(libs.sqlite)
}