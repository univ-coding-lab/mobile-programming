pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyAppOSH"
include(":app")
include(":cweek04a")
include(":cweek05a")
include(":homework2")
include(":cweek07a")
include(":cweek10")
include(":cweek11")
include(":cweek12")
include(":cweek13a")
