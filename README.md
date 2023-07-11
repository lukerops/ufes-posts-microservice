# ufes-post-microservice
API criada na disciplina de microserviços.

## API Endpoints

### Create Post
  **Method:** POST  
  **Endpoint:** `/posts`  
  **Body:**  
  ```json
  {
	"name": "example",
	"title": "example",
	"content": "text",
	"author": 0,
	"medias": [1, 2, 3]
  }
  ```
###   
### Access all Posts
  **Method:** GET  
  **Endpoint:** `/posts`  


###    
### Access Post
  **Method:** GET    
  **Endpoint:** `/posts/{id}`  


###    
### Edit Post
  **Method:** PUT  
  **Endpoint:** `/posts/{id}`  
   - OBS: Only include the data you want to modify  
  ```json
{
	"name": "example",
	"title": "example",
	"content": "text",
	"author": 0,
	"medias": [1, 2, 3]
}
  ```


###    
### Delete Post
  **Method:** DELETE  
  **Endpoint:** `/post/{id}`  


###    
### Access Post by Author
  **Method:** GET  
  **Endpoint:** `/post/author/{id}`  


###    
### Access Media Ids by Post
  **Method:** GET  
  **Endpoint:** `/post/{id}/media`  


## Dependencies
 - Java SDK >= 17
 - Java RE >= 18
 - Java Server VM >= 18
 - MySQL DB

## To run locally:
- On `post-microsservice` folder, run `make run`
- The application will start on `localhost:8081`

## How to Build
 - Clone the Repository
 - On `post-microsservice` folder, run `make build`
 - Wait for Gradlew to download all dependencies and build the project
     - It may take a long time on first time
 - It's all set up!

## How to run tests
 - On `post-microsservice` folder, run `./gradlew test`

### Tips
 - You can also use this repo on `IntelliJ IDEA`. It's usefull for run tests idependently and use imports easily.
