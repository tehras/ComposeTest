@file:JvmName("Deps")

object Versions {
    const val compose = "0.1.0-dev12"
    const val kotlin = "1.3.72"
    const val targetSdk = 29
    const val workflow = "0.28.0"
    const val workflow_compose = "0.30.0"
    const val koin = "2.1.5"
}

object Compose {
    const val animation = "androidx.ui:ui-animation:${Versions.compose}"
    const val core = "androidx.ui:ui-core:${Versions.compose}"
    const val foundation = "androidx.ui:ui-foundation:${Versions.compose}"
    const val layout = "androidx.ui:ui-layout:${Versions.compose}"
    const val material = "androidx.ui:ui-material:${Versions.compose}"
    const val materialIconsExt = "androidx.ui:ui-material-icons-extended:${Versions.compose}"
    const val runtime = "androidx.compose:compose-runtime:${Versions.compose}"
    const val tooling = "androidx.ui:ui-tooling:${Versions.compose}"
}

object Workflow {
    const val compose =
        "com.squareup.workflow:workflow-ui-core-compose:${Versions.workflow_compose}"
    const val composeTooling =
        "com.squareup.workflow:workflow-ui-compose-tooling:${Versions.workflow_compose}"

    const val core = "com.squareup.workflow:workflow-core-jvm:${Versions.workflow}"
    const val runtime = "com.squareup.workflow:workflow-runtime-jvm:${Versions.workflow}"
}

object Android {
    const val appcompat = "androidx.appcompat:appcompat:1.1.0"
}

object Data {
    const val pubgApi = "de.kevcodez.pubg:pubg-api-wrapper:1.0.0"
}

object Koin {
    const val android = "org.koin:koin-android:${Versions.koin}"
    const val core = "org.koin:koin-core:${Versions.koin}"
}

object Kotlin {
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
}