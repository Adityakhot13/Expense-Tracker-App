# 💰 Expense Tracker

> A personal finance management application for logging expenses, organizing them by category, and generating monthly reports.

<!--
📸 ADD YOUR SCREENSHOT(S) HERE
Replace the line below with:
![Expense Tracker Screenshot](./screenshots/homepage.png)
Recommended: a screenshot of the dashboard, the add-expense form, and the monthly report view.
-->
![Expense Tracker Screenshot](./screenshots/demo.png)

---

## 📖 Overview

Expense Tracker is a Java-based personal finance app built with Spring Boot. It handles user management, expense logging, categorization, and monthly financial reporting, following a standard layered architecture (models, DTOs, controllers, services, repositories, and config) under the `com.example.expenseTraker` package.

---

## ✨ Features

- 👤 **User Management** — register and manage users, backed by dedicated request/response DTOs
- 🧾 **Expense Logging** — add expenses via `AddExpenseDTO`, mapped to the `Expense` entity
- 🏷️ **Categorization** — group expenses under `Category`, with category-wise totals via `Category_SumDTO`
- 📊 **Monthly Reporting** — generate monthly summaries via `MonthlyReportDTO`
- 🔐 **Access Control** — security configuration handled through `SecurityConfig`
- 🌱 **Data Seeding** — initial data setup via `DataInitializer`
- 🖥️ **Server-Side Views** — static assets and Thymeleaf-style templates for a simple web UI

---

## 🛠️ Tech Stack

**Backend:** Java · Spring Boot · Spring Data JPA / Hibernate · Spring Security
**Frontend:** HTML (static assets + templates)
**Build Tool:** Maven (with Maven Wrapper)

---

## 🧩 How It Works

1. A user registers and logs in
2. The user logs an expense, assigning it to a category
3. The `expenseService` processes and persists the expense via `ExpenseRepository`
4. At the end of the month, the app aggregates expenses by category and produces a `MonthlyReportDTO` summarizing spending

---

## 📂 Project Structure

```
com.example.expenseTraker
├── model/            # User.java, Expense.java, Category.java
├── DTOs/             # AddExpenseDTO, MonthlyReportDTO, Category_SumDTO, User DTOs
├── controller/        # homeController.java
├── servises/          # expenseService.java, userServise.java
├── repository/        # ExpenseRepository.java, UserRepository.java
└── config/            # SecurityConfig.java, DataInitializer.java

src/main/resources
├── static/            # index.html
└── templates/         # form.html

application.properties
pom.xml
mvnw / mvnw.cmd
PersonalExpenseTrakerApplication.java
PersonalExpenseTrakerApplicationTests.java
```

---

## 🚀 Getting Started

### Prerequisites
- Java (JDK compatible with the project's Spring Boot version)
- No global Maven installation required — use the included Maven wrapper

### Run locally

```bash
git clone https://github.com/Adityakhot13/expense-tracker.git
cd expense-tracker
```

Configure your database credentials in `application.properties`, then:

```bash
# macOS/Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

The app will be available at `http://localhost:<PORT>`.

### Run tests

```bash
./mvnw test
```

Base unit and integration tests run via `PersonalExpenseTrakerApplicationTests.java`.

---

## 🖼️ Screenshots

<!-- Add more screenshots here as needed -->
| Dashboard | Add Expense | Monthly Report |
|---|---|---|
| ![Dashboard](./screenshots/dashboard.png) | ![Add Expense](./screenshots/add-expense.png) | ![Report](./screenshots/report.png) |


---

## 📄 License

This project is open source. Feel free to fork and adapt it.

---

## 👤 Author

**Aditya Khot**
[GitHub](https://github.com/Adityakhot13) · [LinkedIn](https://linkedin.com/in/your-linkedin) · adityakhot1312@gmail.com
