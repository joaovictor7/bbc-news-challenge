plugins {
    alias(libs.plugins.composeTest.library)
}

android {
    namespace = "com.bbcnewschallenge.core.database"
}

dependencies {
    implementation(projects.core.security)
    implementation(projects.core.domain)
    implementation(projects.common)
    implementation(libs.room)
    ksp(libs.room.compile)
}