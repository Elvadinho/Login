# Android Login & Signup Application

This repository contains a simple Android application demonstrating user authentication (Login & Signup) using **SharedPreferrence** as a local database. The app includes input validation, navigation between screens, and a basic landing page with a small guessing game.

---

## 📱 Features

* User Login  
* User Signup / Account Creation  
* Input Validation (Email, Password, Phone Number)  
* SharedPreference Local key-value pair Database Storage  
* Landing Page With Passed User Data  
* Logout Functionality  
* Mini Guessing Game  

---

## 🧩 Project Structure

* **Login Page**  
* **Signup Page**  
* **Landing Page** (final page after successful login)  

---

## 🔐 Login Page

On the login screen, users enter their email and password to access the application.

### **Functionalities:**

* Email validation using **regex**
* Password must contain **at least 8 characters**
* Shows **"Invalid Credentials"** on error
* Redirects to **Landing Page** with passed user data

### **Login Page UI Preview:**

<img src="https://github.com/user-attachments/assets/fd99075f-18bb-4fb3-bf31-1c424ec4c712" width="300"/>

---

## 📝 Signup Page

The signup screen allows new users to create an account.

### **Functionalities:**

* Email validation using regex  
* Password ≥ **8 characters**  
* Gender selection (**Male / Female**)  
* Phone number input  
* Saves user data in **SharedPreferrence**  
* Allows login after successful signup  

### **Signup Page UI Preview:**

<img src="https://github.com/user-attachments/assets/8943eda0-93fd-4f75-986e-854f7b9e86cc" width="300"/>

---

## 🗄️ Shared Preferennce Database

The app stores:

* Email  
* Password  
* Gender  
* Phone Number  

### **Database Responsibilities:**

* Save new user records  
* Validate credentials  
* Retrieve user data for landing page  

---

## 🏠 Landing Page

After successful login, the user is redirected to the Landing Page.

### **Functionalities:**

* Displays:  
  - Email  
  - Password  
  - Phone Number  
* Logout button  
* A **3-level guessing game**

### **Landing Page UI Preview:**

<img src="https://github.com/user-attachments/assets/462aa95f-9366-4a74-9011-ad781a0a94ae" width="300"/>

---

## 🎮 Guessing Game (Mini Feature)

### **How It Works:**

* User enters a guess  
* App generates a random number  
* Displays feedback  

---

## 🚀 How to Run the App

1. Clone the repository:

```bash
git clone https://github.com/Elvadinho/Login.git
```

<img src="https://github.com/user-attachments/assets/01695f36-e51e-4c6e-b7ff-490a6f54808c" width="300"/>
