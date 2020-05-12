job('NodeJS Docker example') {
    scm {
        git('git://github.com/lantossl/hello-nodejs.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('lantossl')
            node / gitConfigEmail('lantos.sl@itvagyunk.info')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('lantossl/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('lantossl_dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
