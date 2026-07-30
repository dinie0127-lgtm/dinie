# dinie
assignment
# Vehicle Registration Assignment

This folder contains a simple Java vehicle registration system with GUI and core model classes.

## Project structure

- `src/` - Java source files:
  - `Vehicle.java`, `Car.java`, `Motorcycle.java`, `Van.java` - model classes
  - `VehicleManager.java` - in-memory manager for vehicles
  - `VehicleRegistrationApp.java` - Swing GUI application
  - `TestRunner.java` - simple console test runner (example usage)
- `bin/` - compiled classes (created by `javac -d bin ...`)

## Requirements

- Java 8 or later

## Build

From the `assignment Java` folder run:

```bash
javac -d bin src/*.java
```

This compiles all sources into the `bin` directory.

## Run the console test runner

```bash
java -cp bin TestRunner
```

Expected sample output (approximate):

```
Adding Car: Model A
Adding Motorcycle: Model B
Adding Van: Model C
Duplicate add failed: Duplicate Error: A vehicle with model 'Model A' already exists!
--- Search results for 'Model A' ---
Vehicle ID: C1, Model: Model A, Brand: BrandX, Engine Capacity: 2.5, Type: Car, Number of doors: 4

--- All registered vehicles ---
Vehicle ID: C1, Model: Model A, Brand: BrandX, Engine Capacity: 2.5, Type: Car, Number of doors: 4
Vehicle ID: M1, Model: Model B, Brand: BrandY, Engine Capacity: 0.6, Type: Motorcycle, Carrier: true
Vehicle ID: V1, Model: Model C, Brand: BrandZ, Engine Capacity: 3.0, Type: Van, Load Capacity: 1200.0
```

## Run the GUI

Running the GUI requires a graphical environment. On headless CI or containers you can use `xvfb-run` if available:

```bash
xvfb-run java -cp bin VehicleRegistrationApp
```

## Notes

- The `TestRunner` is intentionally simple and uses console output to demonstrate expected behaviour.
- If you want proper unit tests, consider adding JUnit and a `pom.xml` or Gradle wrapper.
## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
