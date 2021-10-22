import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {

    buildType(Buildconfig)
    buildType(Secondaconfig)

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "buildtype-graphs"
            param("series", """
                [
                  {
                    "type": "valueTypes",
                    "key": "buildStageDuration:buildStepRUNNER_4",
                    "sourceBuildTypeId": Chartdsl_Buildconfig,
                    "title": "my custom titel"
                  }
                ]
            """.trimIndent())
            param("format", "duration")
            param("hideFilters", "")
            param("title", "Time per step")
            param("defaultFilters", "showFailed")
            param("seriesTitle", "Serie")
        }
        feature {
            id = "PROJECT_EXT_2"
            type = "buildtype-graphs"
            param("series", """
                [
                  {
                    "type": "valueTypes",
                    "key": "buildStageDuration:buildStepRUNNER_4",
                    "sourceBuildTypeId": Chartdsl_Secondaconfig,
                    "title": "my custom titel"
                  }
                ]
            """.trimIndent())
            param("format", "duration")
            param("hideFilters", "")
            param("title", "Time per step")
            param("defaultFilters", "showFailed")
            param("seriesTitle", "Serie")
        }
        feature {
            id = "PROJECT_EXT_9"
            type = "buildtype-graphs"
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Build Step #1 - Command Line \"step1\"",
                    "key": "buildStageDuration:buildStepRUNNER_1"
                  },
                  {
                    "type": "valueType",
                    "title": "Build Step #2 - Command Line \"step2\"",
                    "key": "buildStageDuration:buildStepRUNNER_2"
                  }
                ]
            """.trimIndent())
            param("format", "text")
            param("hideFilters", "")
            param("title", "Time per step")
            param("defaultFilters", "")
            param("seriesTitle", "Serie")
        }
    }
}

object Buildconfig : BuildType({
    name = "buildconfig"

    steps {
        script {
            scriptContent = "echo a"
        }
    }
})

object Secondaconfig : BuildType({
    name = "Secondaconfig"

    steps {
        script {
            name = "step1"
            scriptContent = "echo a"
        }
        script {
            name = "step2"
            scriptContent = "echo a"
        }
    }

    dependencies {
        snapshot(Buildconfig) {
        }
    }
})
