tasks.getByName<Jar>("jar") {
    enabled = false
}
tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    enabled = true
}

dependencies {
    implementation(project(":domain"))
}
