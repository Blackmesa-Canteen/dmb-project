## Description
Backend application with RESTful API. 

Java Spring Boot + MyBatis + Postgres SQL. 

Deployed with one-click Docker Compose.

## Deployment

1. Install Docker and Docker Compose at the host machine;
2. Clone this repository;
3. In the repository directory, run ` docker compose up`;
4. Access the application at `http://localhost:8080/`. For API doc, go to `http://localhost:8080/swagger-ui/index.html`.

**Note:**
1. The database will have initial seed data based on the **Menu Rendering Table** from the requirement document;
2. For initial System Control data, all status are false;
3. There is no initial role. User should create a role and enable permissions for the role before generating menu structure;
4. CORS is enabled for all origins, methods and headers.

## Usage
We are using Swagger for API documentation, where the user can also interact with backend. To interact with backend, follow the steps below:
### 1. Start: 
Deploy & run the app, visit `http://localhost:8080/swagger-ui/index.html`;


### 2. Create a role: 
In **Role** section, go to **POST /api/v1/role/** and click on **Try it out**, configure the request body and click on **Execute** to create a new role;


### 3. Enable permissions for the role: 
Go to **Permission** section, go to **PUT /api/v1/permission/batch/enable** and click on **Try it out**, configure the request body and click on **Execute** to enable permissions for the role;

### 4. Toggle System Status: 
By default, all systems are disabled. To enable a system, go to **System Control** section, go to **PUT /api/v1/system/batch** and click on **Try it out**, configure the request body and click on **Execute** to toggle system status;


### 5. Generate Menu Structure for the role: 
Go to **Menu** section, go to **GET /api/v1/menu/structure/role/{roleId}** and click on **Try it out**, configure the roleId parameter and click on **Execute** to get the menu structure for the roleId;

## Database access
If deployed with docker compose locally, the database is exposed at port 5432. The credentials are in .env file.

## Live Demo
A live demo is available at `https://test.996workers.icu/`.
API documentation is available at `https://test.996workers.icu/swagger-ui/index.html`.
Database is not exposed.

## License
[MIT](https://github.com/Blackmesa-Canteen/dmb-project/blob/master/LICENSE)