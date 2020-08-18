pipeline {
agent { label 'maven'}

//environment {
//PATH = "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe:$PATH"
//}
stages {
stage('Checkout') {
steps {
checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/helozano/java-cucumber-example.git']]]
}
}
stage('Build') {
	steps {
	//echo "$PATH"
		sh script:''' 
		           export DISPLAY=:10
		           mvn -f pom.xml -Ddriverpath="/home/ubuntu/chromedriver" -Dcucumber.options="--plugin json:target/cucumber-report.json" test
		          '''
	}
}
stage('cucumber') {
steps {
cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, reportTitle: 'cucumber', skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
}
}
}
}
