# Briefly

This is a Spring Boot based backend API that provides text summarization by interacting with the Gemini language model API. It exposes REST endpoints for frontend apps to submit text and receive summarized content.

---

## Features

- Exposes `/api/summarize` POST endpoint
- Accepts JSON request with text to summarize
- Calls Gemini API with appropriate authentication
- Returns summarized text response in JSON
- CORS enabled for frontend access (`http://localhost:3000`)
- Timeout and error handling for stable API communication
- Extensible to support multiple language model(OpenAI, etc..)

---

## Prerequisites

- Java 17 or higher
- Maven or Gradle build tool
- Internet access to reach Gemini API
- Valid Gemini API key

---

## Getting Started

### Clone repo
git clone <repo-url>
cd briefly

### Configure API key and URLs

Set your Gemini API key and backend URLs via `application.properties` or environment variables.
Example `application.properties`:
```
summarizer.api.key=<YOUR_GEMINI_API_KEY>
summarizer.api.base-url=<GEMINI_URL? // https://generativelanguage.googleapis.com/v1beta2
```


### Build & Run
Using Maven:
```declarative
./mvnw clean package
java -jar target/briefly-0.0.1-SNAPSHOT.jar
```

The backend will start at `http://localhost:8081` by default.
---
## API Usage

### Summarize Text

- **Endpoint:** `POST /api/summarize`
- **Content-Type:** `application/json`

#### Request Body
```declarative
{
  "tone":"User",
  "text":"Long text you want summarized..."
}
```

#### Response Body
```declarative
{
  "candidates": [
    {
      "content": {
        "parts": [
          {
            "text": "Summarized text here....."
          }
        ],
        "role": "model"
      },
      "finishReason": "STOP",
      "avgLogprobs": -0.33792385743234193
    }
  ],
  "usageMetadata": {
    "promptTokenCount": 440,
    "candidatesTokenCount": 933,
    "totalTokenCount": 1373,
    "promptTokensDetails": [
      {
        "modality": "TEXT",
        "tokenCount": 440
      }
    ],
    "candidatesTokensDetails": [
      {
        "modality": "TEXT",
        "tokenCount": 933
      }
    ]
  },
  "modelVersion": "gemini-2.0-flash",
  "responseId": "nDinaM6cDNuLqtsPr9KmMQ"
}
```

---

## CORS Configuration

The backend allows CORS requests from `http://localhost:3000`[Frontend url] for development. Adjust CORS origins in `WebConfig` accordingly if deploying elsewhere.

---

## Troubleshooting

- Ensure Gemini API key is valid and not expired.
- Check network connectivity from backend to Gemini endpoint.
- Monitor backend logs for detailed errors.
- Adjust request and response timeouts in the `HttpClient` configuration for optimal performance.

---

## Technologies Used

- Spring Boot 3.x
- RestTemplate
- Maven
- Java 21
- Lombok (optional)

---

## License

This project is licensed under the MIT License.




