pipeline{
  agent none
	stages{
		stage('Build with ANT'){
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
		
	}
}