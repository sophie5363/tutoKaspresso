plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(project(":kotlin"))
    implementation(libs.kotlinPlugin)
    implementation(libs.androidPlugin)
}
