node {
  stage("Clone project") {
    git branch: 'main', url: 'https://github.com/jaksil1k/sre'
  }

  stage("Build project with test execution") {
    sh 'chmod +x gradlew'
    sh "./gradlew build"
  }

  stage("Deploy to DockerHub with Jib") {
    withCredentials([string(credentialsId: 'DOCKER_PASSWORD', variable: 'DOCKER_PASSWORD'), string(credentialsId: 'DOCKER_USERNAME', variable: 'DOCKER_USERNAME')]) {
        sh '''
        echo "${DOCKER_PASSWORD}" | docker login -u "${DOCKER_USERNAME}" --password-stdin
        ./gradlew jib -Djib.to.auth.username="${DOCKER_USERNAME}" -Djib.to.auth.password="${DOCKER_PASSWORD}"
        '''
    }
  }
}