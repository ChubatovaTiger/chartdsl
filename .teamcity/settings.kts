
import jetbrains.buildServer.configs.kotlin.v2019_2.*

import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script





fun ProjectFeatures.addGraphs(buildTypeList : List<BuildType>) {

    buildTypeList.forEach {

        feature {

            type = "project-graphs"

            param(

                "series", """

                    [

                      {

                        "type": "valueType",

                        "title": "Time spent in queue",

                        "sourceBuildTypeId": ${it.id},

                        "key": "TimeSpentInQueue"

                      },

                      {

                        "type": "valueType",

                        "title": "Build duration",

                        "sourceBuildTypeId": ${it.id},

                        "key": "BuildDuration"

                      }

                    ]

                """.trimIndent()

            )

            param("format", "duration")

            param("hideFilters", "")

            param("title", "Time spent overall ${it.name}")

            param("defaultFilters", "showFailed")

            param("seriesTitle", "Serie")

        }

        feature {

            type = "project-graphs"

            param(

                "series", """

                    [

                      {

                        "type": "valueType",

                        "title": "Success Rate for ${it.name}",

                        "sourceBuildTypeId": ${it.id},

                        "key": "SuccessRate"

                      }

                    ]

                """.trimIndent()

            )

            param("format", "percentBy1")

            param("hideFilters", "")

            param("title", "Success Rate for ${it.name}")

            param("defaultFilters", "showFailed, averaged")

            param("seriesTitle", "Serie")

        }

    }

    feature {

        type = "buildtype-graphs"

        param(

            "series", """

                    [

                      {

                        "type": "valueTypes",

                        "pattern": "buildStageDuration:*",

                        "title": "Stage: {1}"

                      }

                    ]

            """.trimIndent()

        )

        param("format", "duration")

        param("hideFilters", "")

        param("title", "Time per step")

        param("defaultFilters", "showFailed")

        param("seriesTitle", "Serie")

    }

}



version = "2021.1"



project {



    buildType(Buildconfig)

    buildType(Secondaconfig)

    val buildChain = sequential  {

      buildType(Buildconfig)

      buildType(Secondaconfig)

    }

    features {

    addGraphs(buildChain.buildTypes())

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

})

