# 🎓 Student Management Java Application

A desktop Java application developed in Apache NetBeans as a university practice assignment to strengthen core programming concepts, object-oriented principles, database connectivity, and desktop user interface design.

---

## 🚀 Features

* **User Authentication:** Secure **Login** and **Signup** system handled via dedicated controllers and data access objects (DAO) to control application access.
* **Complete CRUD Operations:** 
  * **Add Data:** Insert new student records seamlessly through the graphical interface.
  * **View Data:** Display and browse stored records in real-time.
  * **Edit Data:** Update and modify existing student information.
  * **Delete Data:** Remove unwanted records from the database system.
* **Integrated Calculator:** A built-in calculator utility module to perform quick mathematical computations directly within the application.

---

## 🛠️ Built With

* **Language:** Java
* **IDE:** Apache NetBeans
* **GUI Framework:** Java Swing
* **Build Tool:** Apache Ant (`build.xml`)
* **Architecture:** MVC (Model-View-Controller) with DAO pattern

---

## 📂 Project Architecture

```text
src/
├── controller/     # Handles business logic and user actions
├── dao/            # Data Access Objects for database communication
├── db/             # Database connection and test configurations
├── model/          # Entity classes (Student, User)
├── studentmanagement/ # Main entry point
└── view/           # Java Swing forms and UI components (.java & .form)

