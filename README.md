# ConnectUs

## Overview
ConnectUs is a REST API-based social networking platform designed to handle user authentication, posting, commenting, liking, following, and image management. This application is built with Spring Boot and includes user authentication using JWT, CRUD functionality for user posts, comments, likes, follows, and image upload and retrieval.

## Technologies Used
- Java 11
- Spring Boot
- Spring Security with JWT for authentication
- MySQL (or any SQL database supported by JPA)
- Maven for dependency management

## Features

### 1. User Authentication & Authorization
- **Register:** Users can sign up by providing their email, name, last name, and password.
- **Login:** Users can log in using email and password, receiving a JWT token upon successful authentication.

---

### 2. User Profiles
- **View Users:** Retrieve details of all users or a specific user by ID.
- **Upload User Profile Image:** Users can upload an image to represent their profile.
- **Download User Profile Image:** Users can view and download profile images.
- **Follow and Unfollow Users:** Users can follow or unfollow other users.
- **Check Follow Status:** Determine if a user is following another user.


---

### 3. Posts
- **Create Posts:** Users can create a new post with text and/or media.
- **View Posts:** Retrieve all posts, a specific post by ID, or all posts by a specific user.
- **View Followed Users' Posts:** Retrieve posts made by users the authenticated user is following.
- **Delete Post:** Users can delete their posts.

---

### 4. Comments
- **Add Comments:** Users can add comments on posts.
- **View Comments:** Retrieve all comments, comments on a specific post, or comments by a specific user.
- **Delete Comments:** Users can delete their own comments.

---

### 5. Likes
- **Like and Unlike Posts:** Users can like or unlike a post.
- **View Likes:** Retrieve all likes on a specific post or likes made by a specific user.
- **Check Like Status:** Determine if a user has liked a specific post.

---

### 6. Image Management for Posts
- **Upload Post Images:** Users can upload images for a specific post.
- **Download Post Images:** Users can view images attached to a post.

---

### 7. Security and Permissions
- **JWT-Based Authentication:** Secure endpoints using JSON Web Tokens to ensure only authenticated users can access protected resources.
- **Password Encryption:** Secure password storage using encoding mechanisms to protect user data.


### Prerequisites
- JDK 17 or higher
- Maven
- MySQL or another relational database
- IDE (like IntelliJ IDEA or Eclipse)

## Contributing
- Contributions are welcome! If you would like to contribute, please fork the repository and create a pull request with a detailed description of your changes.
- We are also open to contributions for the front end, so feel free to improve the user interface or add new features!

## Note: 
Make sure to update application.properties with your database credentials and other configuration details before running the application.




