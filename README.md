# 📌 Overview

Mobility4You е конзолно Java приложение за управление на каталог от автомобили.
Поддържа различни типове превозни средства и позволява четене, добавяне, сортиране и запис във файл.

⚙️ Functionalities
📖 Четене на данни от CSV файл (mobility.csv)
➕ Добавяне на нови автомобили:
Electric Car
Gas Car
Hybrid Car
📋 Показване на целия каталог
🔍 Филтриране по:
тип автомобил
име на автомобил
🔄 Сортиране чрез Comparator (по тип)
💾 Запис обратно във файла

# 🧱 Project Structure
`src/main/
│
├── models/              → Основни домейн класове
│   ├── Vehicle.java
│   ├── builders/        → Builder pattern за създаване на обекти
│   └── type/            → VehicleType enum
│
├── ui/                  → Команди (Command pattern)
│   ├── AddNew*          → Добавяне на автомобили
│   ├── Show*            → Визуализация
│   └── CatalogueWriter  → Запис във файл
│
├── unitility/
│   ├── context/         → Context класове (state management)
│   └── parser/          → Парсване на CSV данни
│
├── constants/           → Error messages
│
├── resources/
│   └── mobility.csv     → Файл с данни
│
└── Main.java            → Entry point`

# 🧠 Key Concepts Used
OOP (Object-Oriented Programming)
Builder Pattern → създаване на различни типове автомобили
Command Pattern → всяко действие е отделен клас
Comparator → сортиране по тип автомобил
Context Pattern (simple state holder) → управление на данни между операции
File I/O (NIO + Streams) → четене/запис на CSV

# 📄 Data Format (CSV)
`ELECTRIC_CAR Tesla, Model 3, 150KW, 50000Ah, 30000 euro
GAS_CAR Honda, Civic, 1.5L, 80KW, 18000 euro
HYBRID_CAR Toyota, Prius, 1.5L, 50KW, 12000Ah, 24000 euro`

# ▶️ How to Run
Отвори проекта в IntelliJ IDEA
Увери се, че src/main/resources е маркиран като Resources Root
Стартирай:
`Main.java`

# ⚠️ Important Notes
Приложението чете и пише директно във файла:
`src/main/resources/mobility.csv`
При реална среда това не е добра практика (resources са read-only при JAR)
Форматирането на числа използва Locale.US за да се избегнат проблеми с , и .
