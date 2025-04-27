
# MotorPH Payroll System

This is a proposed payroll system built for **MotorPH** to help manage employee records and automate payroll processing.

## 🖥️ How to Use the Program

### Option 1: Using an IDE (Recommended) 💻

 1. **Clone the repository**:
	  ` git clone https://github.com/djkier/payroll-system-motorph.git`
	  
 2. **Set up your IDE**:
	- It is recommended to use either **IntelliJ IDEA** or **Eclipse** for this project.
		- **IntelliJ IDEA** [installation guide](https://www.jetbrains.com/help/idea/installation-guide.html).
		- **Eclipse** [installation guide](https://eclipseide.org/).
 3. **Install Adoptium JDK 21:**
	 - Ensure you have **JDK 21** installed. If you don't have it yet, follow the instructions to install it from **[Adoptium's website](https://adoptium.net/installation/)**.
 4. **Open the Project**:
	 - After installing your IDE and JDK, open the project folder you just cloned in your IDE.


### Option 2: Using the Command Line 🖱️

 1. **Ensure you have Maven and JDK 21**:
	 - **JDK 21**: Ensure that **JDK 21** is installed. If you don’t have it, install it by following the instructions  from [here](https://adoptium.net/installation/).
	 - **Maven**: Ensure that you have **Apache Maven** installed. Follow instructions from **[here](https://maven.apache.org/install.html)**.
	  
 2. **Clone the repository**:
	- ` git clone https://github.com/djkier/payroll-system-motorph.git`
	
 3. ****Build the project**:**
	 - Open a terminal/command prompt.
	 - Navigate to the folder where the project was cloned:
		  `cd <path-to-cloned-repository>`
		  
 4. **Open the Project**:
	 - Run the following command to clean and build the project:
		  `mvn clean package`
	 
 5. **Execute the JAR**:
	 - After the build is successful, navigate to the `target` folder and execute the JAR file using the following command:
	  `java -jar target/filename.jar`

## 📌 Features

- **Attach Attendance**
  - Add and manage employee attendance data.

- **View Employee Information**
  - View basic employee details:
    - Name
    - Address
    - Birthday

- **Generate Payslip**
  - Print employee payslips:
    - Full month
    - Half month
    - Custom range

- **Monthly Report**
  - Generate a monthly payroll report for all employees.

## 🛠 Tech Stack

- **Language:** Java 
- **Runtime:** Runs in the **Command Prompt / Terminal**
- **No external libraries required**
