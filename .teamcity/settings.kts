import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.CustomChart
import jetbrains.buildServer.configs.kotlin.v2019_2.CustomChart.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.buildTypeCustomChart

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

version = "2021.2"

project {

    buildType(Stat)
    buildType(StatNonames)

    features {
        buildTypeCustomChart {
            id = "PROJECT_EXT_3"
            title = "nastya"
            seriesTitle = "Serie"
            format = CustomChart.Format.TEXT
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
        }
        buildTypeCustomChart {
            id = "PROJECT_EXT_6"
            title = "nastia"
            seriesTitle = "Serie"
            format = CustomChart.Format.TEXT
            series = listOf(
                Serie(title = "Build Step #1 - Command Line "nastiastep1"", key = SeriesKey.buildStepDuration("RUNNER_1"))
            )
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
