node {
  stage("Clone project") {
    git branch: 'main', url: 'https://github.com/jaksil1k/sre'
  }

  stage("Build project with test execution") {
    sh 'chmod +x gradlew'
    sh "./gradlew build"
  }

  stage("Deploy to DockerHub with Jib") {
    chmod 777 /var/run/docker.sock
    withCredentials([string(credentialsId: 'DOCKER_PASSWORD', variable: 'DOCKER_PASSWORD'), string(credentialsId: 'DOCKER_USERNAME', variable: 'DOCKER_USERNAME')]) {
        sh '''
        echo "${DOCKER_PASSWORD}" | docker login -u "${DOCKER_USERNAME}" --password-stdin
        ./gradlew jib -Djib.to.auth.username="${DOCKER_USERNAME}" -Djib.to.auth.password="${DOCKER_PASSWORD}"
        '''
    }
  }

  jacoco(
    execPattern: '**/*.exec',
    sourcePattern: 'src/main/java',
    exclusionPattern: 'src/test*'
  )
}