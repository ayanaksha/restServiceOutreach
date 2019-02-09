FROM java:8-jre
WORKDIR usr/src
ENV SQL_DATABASE=group16b
ENV SQL_USER=group16b@group16b
ENV SQL_PASSWORD=Password123@
ENV SQL_CI_URL=jdbc:oracle:thin:@group16b.database.windows.net:1443:group16b
ADD ./target/online-sales-service-0.0.1-SNAPSHOT.jar /usr/src/online-sales-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","online-sales-service-0.0.1-SNAPSHOT.jar"]
