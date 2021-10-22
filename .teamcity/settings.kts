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

    buildType(Stat)
    buildType(StatNonames)

    features {
        feature {
            id = "PROJECT_EXT_3"
            type = "buildtype-graphs"
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Build Step #1 - Command Line with id RUNNER_4",
                    "key": "buildStageDuration:buildStepRUNNER_4"
                  },
                  {
                    "type": "valueType",
                    "key": "buildStageDuration:buildStepRUNNER_5"
                  }
                ]
            """.trimIndent())
            param("format", "text")
            param("title", "nastya")
            param("seriesTitle", "Serie")
        }
        feature {
            id = "PROJECT_EXT_6"
            type = "buildtype-graphs"
            param("series", """
                [
                  {
                    "type": "valueType",
                    "title": "Build Step #1 - Command Line \"nastiastep1\"",
                    "key": "buildStageDuration:buildStepRUNNER_1"
                  },
                  {
                    "type": "valueType",
                    "title": "Build Step #2 - Command Line \"nastiastep2\"",
                    "key": "buildStageDuration:buildStepRUNNER_2"
                  }
                ]
            """.trimIndent())
            param("format", "text")
            param("hideFilters", "")
            param("title", "nastia")
            param("defaultFilters", "")
            param("seriesTitle", "Serie")
        }
    }
}

object Stat : BuildType({
    name = "stat"

    steps {
        script {
            name = "nastiastep1"
            scriptContent = "echo a"
        }
        script {
            name = "nastiastep2"
            scriptContent = "echo a"
        }
        script {
            name = "nastiastep3"
            scriptContent = "echo a"
        }
    }
})

object StatNonames : BuildType({
    name = "stat nonames"

    steps {
        script {
            scriptContent = "echo a"
        }
        script {
            scriptContent = "echo a"
        }
        script {
            scriptContent = "echo a"
        }
    }
})
