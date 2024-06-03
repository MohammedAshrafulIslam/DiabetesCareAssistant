# Diabetes Care Assistant

## Overview
Diabetes Care Assistant is a Java-based application designed to assist healthcare professionals in generating personalized treatment plans for patients with diabetes. Developed during a hackathon, this project utilizes Java Swing for its user interface and focuses on managing and using patient data effectively.

## Features
- **Patient Data Management**: Users can input and manage detailed patient information including medical history and current conditions.
- **Automated Prescription Generation**: The application automatically generates a treatment plan based on a predefined list of patients and their medical details stored in `Prescriptions.txt`.
- **Data-Driven Decision Making**: Utilizes stored data to ensure accurate and reliable treatment recommendations.
- **User-Friendly Interface**: Implemented using Java Swing to provide a straightforward and navigable interface for users.

## Technologies Used
- Java 11
- Java Swing for the graphical user interface
- File I/O for data management

## Data Dependencies
This application relies on a predefined dataset contained in `Prescriptions.txt`. Each record includes patient details such as name, age, medical history, current condition, prescribed medication, and dosage.

### File Format
The data file is structured as follows, using tab-separated values (TSV):
- **Name**
- **Age**
- **Medical History**
- **Current Condition**
- **Medication**
- **Dosage**

### Example Data Entry
Maria Thompson 28 "Gestational diabetes, PCOS, no UTI, occasional alcohol" "28 weeks pregnant, UTI diagnosed" Novolin R Flexpen are short acting insulins common for pregnancy 1 per day


## Getting Started

### Prerequisites
- Java JDK 11 or higher.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/MohammedAshrafulIslam/DiabetesCareAssistant.git
2. Navigate to the directory:
   cd DiabetesCareAssistant
   
Running the Application
1. Compile the Java files
   ```bash
     javac -d . *.java
2. Run the main class:
  java aihs.PatientForm

## Usage
Upon starting the application, users will be prompted to input or search for patient data. The application checks this input against the Prescriptions.txt to retrieve and display the appropriate prescription information.

## Acknowledgments
- Thanks to all team members and mentors involved in the hackathon.
