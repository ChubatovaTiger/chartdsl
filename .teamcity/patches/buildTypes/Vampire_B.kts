package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'Vampire_B'
in the project with id = 'Vampire', and delete the patch script.
*/
create(RelativeId("Vampire"), BuildType({
    id("Vampire_B")
    name = "B"

    vcs {
        root(RelativeId("Vampire_HttpsGithubComChubatovaTigerChubatovaGradleTestsBackup"))
        root(DslContext.settingsRoot)
    }
}))

