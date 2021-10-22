

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script


fun ProjectFeatures.addGraphs(buildTypeList : List<BuildType>) {
        
 buildTypeList.forEach {


    feature {

        type = "buildtype-graphs"

        param(

            "series", """

                    [

                      {

                "type": "valueType",
                "title": "Build Step f",
                "sourceBuildTypeId": "${it.id}",
                "key": "buildStageDuration:buildStepRUNNER_1"

                      }
                      {

                "type": "valueType",
                "title": "Build Step d",
                "sourceBuildTypeId": "${it.id}",
                "key": "buildStageDuration:buildStepRUNNER_2"

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



