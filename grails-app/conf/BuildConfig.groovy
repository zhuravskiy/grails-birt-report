grails.project.work.dir = 'target'


//grails.project.repos.default="myRepo"
grails.project.repos.myRepo.url = "http://192.168.1.111:8081/nexus/content/repositories/releases/"
grails.project.repos.myRepo.type = "maven"
grails.project.repos.myRepo.username = "deployment"
grails.project.repos.myRepo.password = "deployment"

grails.project.repos.default="bft"
grails.project.repos.bft.url = "http://172.21.10.166:8097/nexus/content/repositories/missing-artifacts/"
grails.project.repos.bft.type = "maven"
grails.project.repos.bft.username = "deployer"
grails.project.repos.bft.password = "deppass"
//grails.project.repos.myRepo.portal = "grailsCentral"
grails.release.scm.enabled = false

grails.project.dependency.resolver = "ivy" // or ivy
grails.project.dependency.resolution = {
    inherits("global") {
        excludes 'org.eclipse.birt.runtime:org.apache.poi'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        //grailsPlugins()
        mavenCentral()
        grailsHome()
        grailsCentral()

        mavenLocal()


        mavenRepo "http://repo1.maven.org/maven/mule/dependencies/maven2/"
        mavenRepo "http://mirrors.ibiblio.org/maven/mule/dependencies/maven2/"
        mavenRepo "https://code.lds.org/nexus/content/groups/main-repo"
        mavenRepo "http://snapshots.repository.codehaus.org/"
        mavenRepo "http://repository.codehaus.org/"
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repo.spring.io/milestone/"
    }
    dependencies {
        //maven and birt 4.3.0 http://developer.actuate.com/community/devshare/_/deploying-birt-reports/using-birt-430-with-maven-r1483
        compile 'org.eclipse.birt.runtime:org.eclipse.birt.runtime:4.3.0', {
            excludes 'org.eclipse.birt.runtime:org.apache.poi', 'org.milyn:flute', 'org.apache.xerces'
        }
        compile 'org.apache.poi:poi:3.9'
    }

    plugins {
        build(":release:3.0.1", ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}
