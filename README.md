# Binary Search Tree App

## How to Run

1. Make sure you have Java 21 instaled
2. Run: `mvn spring-boot:run`
3. Open browser to: `http://localhost:8080/enter-numbers`

## Features

- **Web Interface**: Enter numbers and see the tree structure
- **Database Storage**: Saves all trees to H2 database
- **Previous Trees**: View all previously created trees
- **JSON API**: Get tree data as JSON

### Web Pages
- `GET /enter-numbers` - Main input form
- `POST /process-numbers` - Process numbers and show result
- `GET /previous-trees` - Show all saved trees

### JSON API
- `POST /api/bst?numbers=5,3,7` - Returns tree as JSON
- `GET /api/bst?numbers=5,3,7` - Returns tree as JSON
- `POST /process-numbers-json?numbers=5,3,7` - Returns tree as JSON