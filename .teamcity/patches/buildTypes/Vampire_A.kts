package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'Vampire_A'
in the project with id = 'Vampire', and delete the patch script.
*/
create(RelativeId("Vampire"), BuildType({
    id("Vampire_A")
    name = "A"

    enablePersonalBuilds = false
    type = BuildTypeSettings.Type.COMPOSITE
    maxRunningBuilds = 1

    vcs {
        root(RelativeId("Vampire_HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup"))

        showDependenciesChanges = true
    }

    dependencies {
        snapshot(RelativeId("Vampire_B")) {
            reuseBuilds = ReuseBuilds.NO
        }
        snapshot(RelativeId("Vampire_C")) {
            reuseBuilds = ReuseBuilds.NO
        }
    }
}))

