# Case Join Project

A full-stack application using Spring Boot, Kafka, and React.

## Architecture

- Frontend: React + TypeScript + Vite
- API: Spring Boot
- Message Broker: Apache Kafka
- Database: PostgreSQL

## Prerequisites

- Docker
- Docker Compose

## Running the Application

1. Clone the repository:
```bash
git clone <your-repo-url>
cd case-join
```

2. Start all services:
```bash
docker-compose up -d
```

This command will start:
- PostgreSQL database
- Kafka and Zookeeper
- Spring Boot API
- Kafka Consumer Service
- React Frontend

3. Access the applications:
- Frontend: http://localhost:3000
- API: http://localhost:8080
- Database: localhost:5432 (if needed)
  - Username: postgres
  - Password: postgres
  - Database: case_join_db

## API Endpoints

### Users
- POST `/api/users` - Create a new user
```json
{
    "name": "Test User",
    "cpf": "123.456.789-10",
    "email": "test@example.com",
    "telephone": "(11) 99999-9999"
}
```

## Stopping the Application

To stop all services:
```bash
docker-compose down
```

To stop and remove all data (including database):
```bash
docker-compose down -v
```

## Development

The application uses:
- React with TypeScript for the frontend
- Spring Boot for the backend API
- Kafka for message processing
- PostgreSQL for data storage

## Troubleshooting

If you encounter any issues:

1. Check if all containers are running:
```bash
docker-compose ps
```

2. Check container logs:
```bash
docker-compose logs -f [service-name]
```
Where [service-name] can be: api, consumer, frontend, kafka, postgres

## Contact

For any questions or issues, please contact:
[Your Contact Information]

# React + TypeScript + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react/README.md) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend updating the configuration to enable type aware lint rules:

- Configure the top-level `parserOptions` property like this:

```js
export default tseslint.config({
  languageOptions: {
    // other options...
    parserOptions: {
      project: ['./tsconfig.node.json', './tsconfig.app.json'],
      tsconfigRootDir: import.meta.dirname,
    },
  },
})
```

- Replace `tseslint.configs.recommended` to `tseslint.configs.recommendedTypeChecked` or `tseslint.configs.strictTypeChecked`
- Optionally add `...tseslint.configs.stylisticTypeChecked`
- Install [eslint-plugin-react](https://github.com/jsx-eslint/eslint-plugin-react) and update the config:

```js
// eslint.config.js
import react from 'eslint-plugin-react'

export default tseslint.config({
  // Set the react version
  settings: { react: { version: '18.3' } },
  plugins: {
    // Add the react plugin
    react,
  },
  rules: {
    // other rules...
    // Enable its recommended rules
    ...react.configs.recommended.rules,
    ...react.configs['jsx-runtime'].rules,
  },
})
```
