FROM jboss/wildfly:24.0.0.Final

COPY target/todo-list-javaee-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/todo-list-javaee.war