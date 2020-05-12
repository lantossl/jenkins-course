job('NodeJS example') {
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
        shell("npm install")
    }
}
