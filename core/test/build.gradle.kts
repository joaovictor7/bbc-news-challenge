plugins {
    alias(libs.plugins.composeTest.library)

}

android {
    namespace = "com.bbcnewschallenge.core.test"
}

dependencies {
    implementation(libs.junit5)
    implementation(libs.kotlin.coroutines.test)
}