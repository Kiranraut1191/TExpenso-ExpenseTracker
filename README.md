# TExpenso-ExpenseTracker

TExpenso is a Full Stack Expense Tracking Application developed using:

- 🧠 **Spring Boot (Java)** for the Backend
- ⚡ **Angular** for the Frontend
- 🗃️ MySQL Database
- 📦 REST APIs


## 🚀 Features

- 🔐 User Registration & Login
- 💸 Send / Receive Transactions
- 📊 View Total/Current Balance
- 📅 Filter Expenses by Date
- 📁 Full User Management
- 📈 Dashboard with All Expenses
- 👁️ View  all users & delete 


## 🛠️ Technologies Used

| Layer         | Technology                    |
|---------------|-------------------------------|
| Backend       | Java, Spring Boot, JPA, MySQ  |
| Frontend      | Angular, TypeScript, HTML/CSS |
| Database      | MySQL                         |
| API Testing   | Postman                       |
| Build Tool    | Maven                         |


## 📂 Project Structure

TExpenso-ExpenseTracker/
├── BACKEND/texpenso/          # Spring Boot backend
│   └── src/main/java/com/rk/
├── FRONTEND/                  # Angular frontend
│   └── src/app/
├── README.md


## ⚙️ Setup Instructions

### 🖥️ Backend (Spring Boot)

1. Navigate to the backend folder:

   ```bash
   cd BACKEND/texpenso

2. Configure your `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/texpenso
   spring.datasource.username=root
   spring.datasource.password=your_password

3. Run the Spring Boot application:

   mvn clean install
   mvn spring-boot:run

### 🌐 Frontend (Angular)

1. Navigate to the frontend folder:

   ```bash
   cd FRONTEND

2. Install dependencies:

   ```bash
   npm install

3. Run the Angular dev server:

   ```bash
   ng serve

   Open in browser: `http://localhost:4200/`


🌐 Backend REST API

| Method | Endpoint                          | Description          |
| ------ | --------------------------------- | -------------------- |
| POST   | `/api/user/register`              | Register user        |
| POST   | `/api/user/login`                 | Login                |
| GET    | `/api/user/all`                   | Get all users        |
| DELETE | `/api/user/delete/{id}`           | Delete user          |
| GET    | `/api/user/get/{id}`              | Get user by ID       |
| GET    | `/api/balance/get/{id}`           | Get balance          |
| POST   | `/api/expense/penny/send/{id}`    | Send money           |
| POST   | `/api/expense/penny/get/{id}`     | Receive money        |
| GET    | `/api/expense/getall/{id}`        | Get all expenses     |
| GET    | `/api/expense/getbyDate/{id}/...` | Get expenses by date |


## 📸 Screenshots

### 🔐 Login Page
![Login](https://github.com/user-attachments/assets/6bf8bcb6-0558-42b0-8ed4-e0187378d286)

### 🏠 Dashboard
![Dashboard](https://github.com/user-attachments/assets/cb9bf978-3a46-4562-bfec-42daf1858b65)

### 💸 Add Expense
![Add Expense](https://github.com/user-attachments/assets/6d829228-2098-44d6-9b8c-bc271b222d9f)

### 📊 Balance Overview
![Balance](https://github.com/user-attachments/assets/f325a210-9bf7-4452-9471-5a4619430a45)

### 👥 User Management
![Users](https://github.com/user-attachments/assets/f5cfa353-812e-4738-8793-687c5328af42)



## 📬 Contact

**Kiran Raut**
Email: krau822@gmail.com
GitHub: https://github.com/Kiranraut1191

## 🌟 Give it a Star!

If you found this project helpful, please consider starring ⭐ the repo.

