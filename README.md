# AI Gateway Service

A Spring Boot middleware service that acts as a gateway between clients and the OpenRouter AI API.

This service includes three different AI personalities:

- Grandma
- Kid
- Jealous partner

## Example Request

Endpoint:

```http
POST /chat
```

```json
{
  "personality": "grandma",
  "message": "How do I make chocolate chip cookies?",
  "sessionId": "session-123"
}
```
---

## Requirements

- Java 25
- Maven
- OpenRouter API key  
  Obtain one for free at https://openrouter.ai

---

## Setup & Running

### 1. Clone the repository

```bash
git clone https://github.com/FionaSprinkles/ai-gateway-service.git
cd ai-gateway-service
```
---

### 2. Open the project in your preferred IDE

---

### 3. Configure environment variables

The application requires an API key to communicate with OpenRouter.

#### Windows PowerShell

```powershell
$env:SUPER_SECRET_KEY="your_api_key_here"
```

#### Linux / macOS

```bash
export SUPER_SECRET_KEY=your_api_key_here
```

---

### 4. Run the application

```bash
./mvnw spring-boot:run
```

---

### 5. Access the application

Swagger Documentation:

http://localhost:8080/swagger-ui/index.html
