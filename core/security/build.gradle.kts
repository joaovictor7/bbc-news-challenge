plugins {
    alias(libs.plugins.composeTest.library)
}

android {
    namespace = "com.composetest.core.security"
}

dependencies {
    implementation(projects.common)
    implementation(libs.sqlCipher)
    implementation(libs.sqLite)
}