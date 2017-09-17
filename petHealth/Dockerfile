from java:8
expose 8080
add target/petHealth-0.0.1-SNAPSHOT.jar /opt/phealth.jar
workdir /opt
entrypoint ["java","-jar","phealth.jar"]