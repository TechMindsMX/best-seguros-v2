import grails.util.BuildSettings
import grails.util.Environment

def bySecond = timestamp("dd-MM-yyyy HH:mm:ss")

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

appender('ROLLING',RollingFileAppender){
  encoder(PatternLayoutEncoder){
    pattern = "%level $logger - \t%m%n"
  }
  rollingPolicy(TimeBasedRollingPolicy){
    FileNamePattern = "build/logs/best_seguros-%d{yyyy-MM}.log"
  }
}

root(ERROR, ['STDOUT'])

def targetDir = BuildSettings.TARGET_DIR
if (Environment.isDevelopmentMode() && targetDir) {
    appender("FULL_STACKTRACE", FileAppender) {
        file = "${targetDir}/stacktrace.log"
        append = true
        encoder(PatternLayoutEncoder) {
            pattern = "%level %logger - %msg%n"
        }
    }
    logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)
}
