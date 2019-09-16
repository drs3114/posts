#!/usr/bin/env bash

function copyEnvVarsToGradleProperties {
    GRADLE_PROPERTIES=$HOME"/.gradle/gradle.properties"
    export GRADLE_PROPERTIES
    echo "Gradle Properties should exist at $GRADLE_PROPERTIES"

    if [ ! -f "$GRADLE_PROPERTIES" ]; then
        echo "Gradle Properties does not exist"

        echo "Creating Gradle Properties file..."
        touch $GRADLE_PROPERTIES

        echo "Writing osshUsername to gradle.properties..."
        echo "ossrhUsername=$OSSRH_USERNAME" >> $GRADLE_PROPERTIES

        echo "Writing osshUsername to gradle.properties..."
        echo "ossrhPassword=$OSSRH_PASSWORD" >> $GRADLE_PROPERTIES
    fi
}