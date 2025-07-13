# bdcc-ai

A simple Spring Boot chatbot project using [Spring AI](https://docs.spring.io/spring-ai/reference/) with support for both OpenAI (GPT-4o) .  
Created for the Prompt Engineering TP with Mohamed YOUSSFI.

---

## Features

- Chat with OpenAI GPT-4o or Ollama Llama3 models via REST API
- Memory and context support (Spring AI auto-configured)
- Easily extensible for more models

---

## Requirements

- Java 21+
- Maven 3.8+
- OpenAI API key
---

## Setup

### 1. Clone the repository

```bash
git clone <your-repo-url>
cd bdcc-ai
```

### 2. Configure your API keys

Edit `src/main/resources/application.properties`:

```properties
# App name and server port
spring.application.name=bdcc-ai
server.port=8089

# OpenAI configuration
spring.ai.openai.api-key=sk-...your-openai-key...
spring.ai.openai.chat.options.model=gpt-4o

# Logging (optional)
logging.level.org.springframework.ai.chat.client.advisor=DEBUG
```

**Important:** Never commit your OpenAI API key to a public repository.

### 3. Install dependencies

```bash
mvn clean install
```

---

## Running the Application

```bash
mvn spring-boot:run
```

The app will start on http://localhost:8089.

---

## API Usage

### 1. Chat with OpenAI (GPT-4o)

```http
GET /api/multimodel/openai?message=Hello%20AI
```

### 3. Example with `curl`

```bash
curl "http://localhost:8089/api/multimodel/openai?message=What is AI?"
curl "http://localhost:8089/api/multimodel/llama3?message=What is AI?"
```

---

## Project Structure

- `controllers/` — REST API endpoints for chat
- `service/` — Chatbot logic (if you add more features)
- `config/` — Beans for multi-model support
- `application.properties` — Model and API configuration

---

## Notes

- Spring AI auto-configures chat memory and context for you.
- You can extend this project to add more models or advanced prompt engineering features.
- For more info, see the [Spring AI documentation](https://docs.spring.io/spring-ai/reference/).

---

## License

This project is created for educational purposes as part of the Prompt Engineering TP with Mohamed YOUSSFI.