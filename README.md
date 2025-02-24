# 🌌 Advanced Calculator Project

## 📌 Overview

The **Advanced Calculator** is a versatile Java-based application designed to perform a wide range of mathematical operations. It features both a **console-based interface** and a stylish, **space-themed GUI**, giving users flexibility and an engaging experience. The application is built with modularity in mind, leveraging a shared `CalculatorCore` class to ensure consistency across interfaces.

Developed as an interactive calculator project, it supports **basic arithmetic, scientific functions, memory operations, and history tracking**, all while accurately evaluating expressions using the **BODMAS rule**.

---

## ✨ Features

✅ **Basic Arithmetic:** Addition (+), Subtraction (-), Multiplication (\*), Division (/).  
✅ **Scientific Functions:**

- Square Root (`sqrt`)
- Trigonometric Functions: Sine (`sin`), Cosine (`cos`), Tangent (`tan`)
- Logarithmic Functions: Natural Log (`ln`), Base-10 Log (`log`)
- Exponentiation (`^`)
  ✅ **Memory Functions:** Store (`M+`), Recall (`MR`), Clear (`MC`).  
  ✅ **History Tracking:** View past calculations using the `HIST` option/button.  
  ✅ **BODMAS Support:** Correct operator precedence (e.g., `3 + 5 * 2 = 13`).  
  ✅ **Error Handling:** Catches and displays errors (e.g., division by zero, invalid logarithms).  
  ✅ **Interfaces:**
- 🖥 **Console:** Interactive text-based interface.
- 🎨 **GUI:** Space-themed design with neon colors and glowing buttons.
  ✅ **Delete Functionality:** `DEL` button in GUI for removing the last input character.

---

## 📂 Project Structure

```
📁 AdvancedCalculatorProject
 ├── CalculatorCore.java       # Core logic for calculations, memory, and history
 ├── AdvancedCalculator.java   # Console-based interface
 ├── AdvancedCalculatorGUI.java # Space-themed GUI interface
 ├── CalculatorLauncher.java   # Entry point to choose between console & GUI modes
```

---

## ⚙️ Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Optional:** Install the "Orbitron" font for a futuristic GUI look (download from Google Fonts).

---

## 🚀 Setup Instructions

### 🔹 Clone/Download the Project:

Copy the `.java` files into a single directory.

### 🔹 Compile the Code:

```sh
javac *.java
```

### 🔹 Run the Application:

```sh
java CalculatorLauncher
```

A dialog will prompt you to choose between **Console** or **GUI** mode.

### 🔹 Font Setup (Optional):

For the GUI’s space theme, install the **"Orbitron" font** on your system, or add the `.ttf` file to your project and update `AdvancedCalculatorGUI.java` accordingly.

---

## 🎮 Usage Examples

### 📌 Console Mode

```sh
java CalculatorLauncher
```

- **Evaluate Expression:** Enter `3 + 5 * 2`, output: **Result: 13**
- **Tangent:** Enter `45`, output: **Result: 1.0**
- **Log Base 10:** Enter `100`, output: **Result: 2.0**
- **History:** View past calculations using `HIST`
- **Exit:** Type `exit`

![alt image](https://github.com/RingkhangBTY/Advanced_Calculator-GUI-/blob/b676847d32a76a833cf043692f343de7c0dadeff/ConsoleTheme.jpg)

### 🎨 GUI Mode

```sh
java CalculatorLauncher
```

- **Example Operations:**
  - Enter `3 + 5 * 2`, click `=`, output: **13**
  - Enter `45`, click `tan`, output: **1.0**
  - Enter `100`, click `log`, output: **2.0**
  - Click `DEL` to remove the last character
  - Click `HIST` to view calculation history

---

## 🪐 Space-Themed GUI

🎨 **Design:**

- **Background:** Starry gradient from deep blue to purple.
- **Colors:** Neon cyan text and glowing button effects.
- **Font:** "Orbitron" for a futuristic, sci-fi aesthetic.
- **Layout:** Rounded edges and a transparent cosmic theme.

![alt text](https://github.com/RingkhangBTY/Advanced_Calculator-GUI-/blob/b676847d32a76a833cf043692f343de7c0dadeff/SpaceTheme.jpg)



## 📌 Notes

🔹 **Error Handling:** Prevents invalid calculations (e.g., division by zero).  
🔹 **Extensibility:** Easily add new functions by updating `CalculatorCore.java`.  
🔹 **Font Fallback:** Defaults to a standard font (e.g., Arial) if "Orbitron" isn’t installed.

---

## 🔮 Future Enhancements

- 🔹 Add a **Clear** button to reset the display.
- 🔹 Support for **complex expressions** with nested parentheses.
- 🔹 Save history to a file for persistence.

---

🚀 **Happy Calculating!** 🪐
