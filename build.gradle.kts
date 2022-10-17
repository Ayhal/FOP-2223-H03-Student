@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    java
    application
    alias(libs.plugins.jagr)
}

jagr {
    assignmentId.set("h03")
    submissions {
        val main by creating {
// ACHTUNG! Entfernen Sie '//' in den folgenden Zeilen und setzen Sie Ihre TU-ID (NICHT Matrikelnummer!), Vor- und Nachnamen ein.
//            studentId.set("ab12cdef")
//            firstName.set("FirstName")
//            lastName.set("LastName")
        }
    }
    graders {
        val graderPublic by creating {
            graderName.set("FOP-2223-H03-Public")
            rubricProviderName.set("h03.H03_RubricProvider")
        }
    }
}

dependencies {
    implementation(libs.algoutils.student)
    implementation(libs.annotations)
    implementation(libs.fopbot)
    // JUnit only available in "test" source set (./src/test)
    testImplementation(libs.junit)
}

application {
    mainClass.set("h03.Main")
}

tasks {
    val runDir = File("build/run")
    named<JavaExec>("run") {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
    }
    test {
        doFirst {
            runDir.mkdirs()
        }
        workingDir = runDir
        useJUnitPlatform()
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
}
