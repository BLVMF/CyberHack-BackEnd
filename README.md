# CyberHack-BackEnd

⚠️ **Note: This Project is for Educational Purposes**

This project is part of a school assignment and is intended solely for educational purposes. As such, it is not open for contributions from external sources. Please be aware that any contributions outside of the course requirements will not be accepted.

Thank you for your understanding and cooperation.

-- BLVMF


**Cyber Hack**
Cyber Hack is a web application designed to connect NGOs (Non-Governmental Organizations) with CyberSecurity volunteers. The platform aims to facilitate collaboration between NGOs seeking CyberSecurity expertise and volunteers willing to contribute their skills for the greater good.

**Technologies Used**
The Cyber Hack project utilizes the following technologies:

Spring Boot: A powerful Java-based backend framework for building robust and scalable applications.
JWT (JSON Web Tokens): Used for secure authentication and authorization of users.
MySQL: A relational database management system for storing application data.

**Features**
Cyber Hack offers the following key features:

**NGO Registration and Posting:**
NGOs can register on the platform and post their CyberSecurity-related needs and requirements. They can provide detailed information about their projects and the specific CyberSecurity expertise they require.

**Volunteer Registration and Profile Creation:**
CyberSecurity experts willing to contribute their skills can register as volunteers on the platform. They can create and manage their profiles, showcasing their skills, experience, and interests.

**Secure Authentication:**
The application uses JWT token authentication to protect sensitive user data and ensure secure access. Users must authenticate themselves with valid tokens to use the platform's features.

**User Account Management:**
NGOs and volunteers can update and delete their accounts as needed. They have control over their profile information and can modify it as their circumstances change.

**Viewing NGOs and Volunteers:**
NGOs can browse through the profiles of registered volunteers and find suitable matches for their needs. Similarly, volunteers can view the NGOs' projects and requirements to identify opportunities where they can contribute.

**Contacting NGOs/Volunteers:**
When an NGO finds a volunteer whose expertise aligns with their needs, they can click on a "Contact" button to initiate communication. This action should open the mail client with a pre-filled email template to streamline the communication process.

**Getting Started
Prerequisites**
Before running the application, make sure you have the following prerequisites installed on your system:

Java JDK: Ensure you have Java Development Kit installed on your machine.
MySQL Database: Set up a MySQL database to store application data.

**Installation**
Clone the Cyber Hack repository from https://github.com/BLVMF/CyberHack-BackEnd.git.
Install the required dependencies and packages.

**Configuration**
Set up the MySQL database and configure the application to connect to it.

**Running the Application**
Launch the backend server using Spring Boot.

**Authentication Endpoints**


**Create JWT Token**
Endpoint: /authenticate
Method: POST
Description: Authenticates the user and generates a JWT token for subsequent API requests.
Request Body:
json

{
  "userName": "string",
  "password": "string"
}
Response Body:
json
{
  "jwtToken": "string"
}
Status Codes:
200: Success
401: Unauthorized (invalid credentials)

**User Endpoints**
Get User by UserName
Endpoint: /users/{userName}
Method: GET
Description: Retrieves user information by their UserName.
Response Body:
json
{
  "userName": "string",
  "userFirstName": "string",
  "userLastName": "string",
  "userEmail": "string",
  "userPhone": "string",
  "volInterests": "string",
  "linkedIn": "string",
  "avNow": "boolean",
  "userRole": "string"
}
Status Codes:
200: Success
404: User not found

**Update User by UserName**
Endpoint: /users/{userName}
Method: PUT
Description: Updates user information based on their UserName.
Request Body:
json
{
  "userFirstName": "string",
  "userLastName": "string",
  "userEmail": "string",
  "userPhone": "string",
  "volInterests": "string",
  "linkedIn": "string",
  "avNow": "boolean"
}
Response Body:
json
Copy code
{
  "userName": "string",
  "userFirstName": "string",
  "userLastName": "string",
  "userEmail": "string",
  "userPhone": "string",
  "volInterests": "string",
  "linkedIn": "string",
  "avNow": "boolean",
  "userRole": "string"
}
Status Codes:
200: Success
404: User not found

**Register New User**
Endpoint: /users/registerNewUser
Method: POST
Description: Registers a new user.
Request Body:
json
{
  "userName": "string",
  "userFirstName": "string",
  "userLastName": "string",
  "userEmail": "string",
  "userPhone": "string",
  "volInterests": "string",
  "linkedIn": "string",
  "avNow": "boolean",
  "userPassword": "string",
  "userRole": "string"
}
Response Body:
json
{
  "userName": "string",
  "userFirstName": "string",
  "userLastName": "string",
  "userEmail": "string",
  "userPhone": "string",
  "volInterests": "string",
  "linkedIn": "string",
  "avNow": "boolean",
  "userRole": "string"
}
Status Codes:
200: Success
400: User already registered

**Delete User**
Endpoint: /users/{userName}
Method: DELETE
Description: Deletes a user based on their UserName.
Response Body:
json
{
  "message": "string"
}
Status Codes:
200: Success
404: User not found

**Get NGOs or Volunteers**
Endpoint: /users
Method: GET
Description: Retrieves a list of NGOs or volunteers based on their userRole.
Query Parameter:
userRole: String ("ngo", "volunteer", or "admin")
Response Body:
json
{
  "userName": "string",
  "userFirstName": "string",
  "userLastName": "string",
  "userEmail": "string",
  "userPhone": "string",
  "volInterests": "string",
  "linkedIn": "string",
  "avNow": "boolean",
  "userRole": "string"
}

Status Codes:
200: Success
400: Invalid userRole

**Update Password**
Endpoint: /users/{userName}/password
Method: PUT
Description: Updates the user's password.
Request Body:
json
{
  "currentPassword": "string",
  "newPassword": "string"
}
Response Body:
json
{
  "message": "string"
}
Status Codes:
200: Success
401: Unauthorized (incorrect current password)
404: User not found

**Reset Password**
Endpoint: /users/{userName}/reset-password
Method: PUT
Description: Resets the user's password to a new value.
Request Body:
json
{
  "newPassword": "string"
}
Response Body:
json
{
  "message": "string"
}
Status Codes:
200: Success
404: User not found


**Authentication**
Cyber Hack uses JWT token authentication to secure user data and authorize access to different parts of the application.

**Database**
The MySQL database schema for the Cyber Hack application consists of a single table named users. Below is the description of the table and its columns:

Table: users

user_name: The primary key of the table, representing the unique user name of each user.
av_now: A field indicating whether the user is available now.
has_crim_check: A field indicating whether the user has a criminal check.
curr_pos: The current position of the user.
level_of_education: The level of education of the user.
linkedin: The LinkedIn profile of the user.
ngo_needs: Information related to the needs of the NGO associated with the user.
user_email: The email address of the user.
user_first_name: The first name of the user.
user_last_name: The last name of the user.
user_password: The password of the user.
user_phone: The phone number of the user.
user_role: The role of the user (e.g., "ngo," "volunteer," or "admin").
vol_interests: The interests of the volunteer associated with the user.
wkly_hrs: The number of weekly hours the user can volunteer.
work_refs: Information related to work references of the user.
years_of_exp: The years of experience of the user.
The table has a primary key on the user_name column, which ensures each user has a unique user name. This table holds user data for both NGOs and volunteers, with different fields capturing specific information for each type of user.

**Contributing**
This project is part of a school assignment and is not open for contributions. It is intended for educational purposes, and any contributions outside of the course requirements will not be accepted. Thank you for your understanding.


[MIT License](LICENSE)
