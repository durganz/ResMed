FROM openjdk:11-jre
ARG JAR_FILE=target/rockpaperscissors-*.jar
COPY ${JAR_FILE} rockpaperscissors.jar
ENTRYPOINT ["java", "-jar", "-Dspring.java .active=development", "rockpaperscissors.jar"]