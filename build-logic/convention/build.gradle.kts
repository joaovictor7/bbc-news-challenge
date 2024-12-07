plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.tools.build.gradle)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.compose.gradle.plugin)
}

gradlePlugin {
    plugins {
        fun registerPlugin(id: String, className: String) {
            register(id) {
                this.id = id
                this.implementationClass = className
            }
        }
        registerPlugin(
            id = "com.bbcnewschallenge.application",
            className = "ApplicationConventionPlugin"
        )
        registerPlugin(
            id = "com.bbcnewschallenge.library",
            className = "LibraryConventionPlugin"
        )
        registerPlugin(
            id = "com.bbcnewschallenge.compose",
            className = "ComposeConventionPlugin"
        )
        registerPlugin(
            id = "com.bbcnewschallenge.test",
            className = "TestConventionPlugin"
        )
    }
}