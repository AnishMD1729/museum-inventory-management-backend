Museum Inventory
This project is an inventory management system for a museum. It allows museum staff and administrators to track the location and other details of artifacts in the museum's collection.

Features
Artifact tracking: Museum staff and administrators can view and update the details of artifacts in the museum's collection, including the artifact's name, description, country of origin, and storage location.
RFID tag integration: The system allows for the use of RFID tags to track the location of artifacts.
Email notifications: The system can send email notifications to staff and administrators when the storage location of an artifact is updated.
Requirements
Java 11 or later
Maven
A database management system (PostgreSQL, MySQL, etc.)
Installation
Clone the repository:

Copy code
git clone https://github.com/USERNAME/REPO_NAME.git
Navigate to the project directory:

Copy code
cd museum-inventory
Compile the project using Maven:

Copy code
mvn clean install
Set up the database by modifying the spring.datasource.url, spring.datasource.username, and spring.datasource.password properties in the application.properties file.

Run the project using Maven:

Copy code
mvn spring-boot:run
The application will be accessible at http://localhost:8080/.
