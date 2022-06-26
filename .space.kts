job("Build, run tests, publish") {
    container(displayName = "Run publish script", image = "maven:3-openjdk-8-slim") {
        // url of a Space Packages repository
        env["REPOSITORY_URL"] = "https://maven.pkg.jetbrains.space/mycompany/p/key/my-maven-repo"

        shellScript {
            content = """
                echo Build and publish artifacts...
                set -e -x -u
                mvn versions:set -DnewVersion=1.0.${'$'}JB_SPACE_EXECUTION_NUMBER
                mvn test
                mvn deploy -s settings.xml \
                    -DrepositoryUrl=${'$'}REPOSITORY_URL \
                    -DspaceUsername=${'$'}JB_SPACE_CLIENT_ID \
                    -DspacePassword=${'$'}JB_SPACE_CLIENT_TOKEN
            """
        }
    }
}