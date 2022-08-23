## retrieve ticket

### input
```json
{
    "origin": "FLN",
    "destination": "SAO",
    "date": "01-07-2022"
}
```

### output
```json
{
  "company": "LATAM Airlines Brasil",
  "origin": "FLN",
  "destination": "SAO",
  "date": "01-07-2022",
  "price": 980.19
}
```

## retrieve all solicitations

### input 
```json
[
  {
    "origin": "FLN",
    "destination": "SAO",
    "date": "01-07-2022"
  },
  {
    "origin": "SAO",
    "destination": "FLN",
    "date": "20-07-2022"
  }
]
```

### output
```json
{
	"cheapestTickets": [
		{
			"company": "LATAM Airlines Brasil",
			"origin": "FLN",
			"destination": "GRU",
			"date": "01-07-2022",
			"price": 980.19
		},
		{
			"company": "LATAM Airlines Brasil",
			"origin": "CGH",
			"destination": "FLN",
			"date": "20-07-2022",
			"price": 412.44
		}
	],
	"summary": {
		"error": [
			"Error message"
		]
	}
}
```

