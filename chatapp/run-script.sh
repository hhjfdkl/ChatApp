# Script to run application
# Database config (for H2 as example)
export SPRING_DATASOURCE_URL=
export SPRING_DATASOURCE_USERNAME=
export SPRING_DATASOURCE_PASSWORD=
# export SPRING_JPA_HIBERNATE_DDL_AUTO=update
# export SPRING_H2_CONSOLE_ENABLED=true

# Use to bypass Spring Security login for testing
# export SPRING_SECURITY_USER_NAME=
# export SPRING_SECURITY_USER_PASSWORD=

# Run Maven Spring Boot App
./mvnw spring-boot:run
