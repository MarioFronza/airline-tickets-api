<h1 align="center">
  <img src="src/main/resources/images/logo.png" alt="Airline Tickets API" width="300">
  <br>
</h1>


<h2 align="center">
Airline Tickets API
</h2>

<p align="center">Retrieve airline tickets from different integrations</p>

## Requirements

- [JDK 11](https://sdkman.io/)
- [Kotlin 1.7.10](https://sdkman.io/)

## Technologies/Frameworks

- [Gradle](https://gradle.org/)
- [Ktor](https://ktor.io/)
- [OkHttp](https://square.github.io/okhttp/)
- [JUnit4](https://junit.org/junit4/)

## Start

To start the application, execute a Gradle Wrapper *run* task.

```bash
./gradlew run
```

## Heroku

Test requesting your solicitations using heroku.

```
curl --request GET \
--url 'https://airline-tickets-api.herokuapp.com/retrieve-solicitations'
```

## Endpoints

### REST

- ***GET*** /retrieve-solicitations

<details>
 <summary><b>Response</b></summary>
    
```json
{
  "cheapestTickets": [
    {
      "company": "LATAM Airlines Brasil",
      "origin": "FLN",
      "destination": "GRU",
      "date": "01-09-2022",
      "price": 1031.48
    },
    {
      "company": "LATAM Airlines Brasil",
      "origin": "SDU",
      "destination": "CGH",
      "date": "01-10-2022",
      "price": 446.83
    }
  ],
  "summary": {
    "error": [
      "Could not extract tickets for SAO to FLN"
    ]
  }
}
```
</details>

## Tests

```bash
./gradlew test
```
