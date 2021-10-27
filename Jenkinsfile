pipeline{
  agent none
	stages{
		stage('Build with ANT'){
			agent {label 'master'}
			steps{
				withAnt(installation: 'Ant_1.10.12', jdk: 'jdk1.8.0_161') {
				sh 'ant -f build.xml'
				}
			}
		}
		stage('Test'){
			agent {label 'master'}
			steps{
				junit allowEmptyResults: true, testResults: 'build/test-reports/*.xml'
			}
		}
		stage('deployment'){
			agent {label 'master'}
			steps{
				sshPublisher(publishers: [sshPublisherDesc(configName: 'server102', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: 'mv /home/antbuildfiles/app.jar /usr/local', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: 'build/', sourceFiles: 'build/*.xml')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
			}
		}
		
	}
}