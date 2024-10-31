# Shop Manager

Shop Manager is a simple yet effective Java-based project aimed at managing users and items within a shop. This application demonstrates core OOP principles, unit testing, and a user-friendly command-line interface to manage shop functionalities. 

## Features

- **User Management**: Create, update, and manage users.
- **Shop Operations**: Add, remove, and display items in the shop.
- **Interface Implementation**: Uses interfaces `iShop` and `iUser` for extensibility.
- **Unit Testing**: Comprehensive unit tests ensure application reliability.
- **Menu-Driven Console UI**: User-friendly interface for interacting with the system.

## Project Structure

The project is structured into several Java classes:

- **`Main.java`**: The entry point of the application. It manages the initialization and runs the main menu loop.
- **`Menu.java`**: Handles user interactions and displays options for navigating the app.
- **`Shop.java`**: Implements shop operations like adding and displaying items.
- **`User.java`**: Manages user details and interactions.
- **`iShop.java` & `iUser.java`**: Interfaces that define the contracts for `Shop` and `User` classes.
- **`UnitTests.java`**: Contains test cases to validate the application's core functions.

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ecinteza/shop-manager.git
   cd shop-manager/src
   ```

2. **Compile the Code**:
   ```bash
   javac *.java
   ```

3. **Run the Application**:
   ```bash
   java Main
   ```

4. **Run Unit Tests**:
   Ensure you have JUnit or any other testing framework compatible with your environment.
   ```bash
   java UnitTests
   ```

## Requirements

- **Java 11+**
- **JUnit** (for running unit tests)

## Usage

### Main Features

- **User Management**:
  - Create new users.
  - View existing user details.
  - Update user information.
- **Shop Management**:
  - Add new items to the shop.
  - View all items in stock.
  - Remove items from the shop inventory.

### Menu Navigation

Run the `Main.java` to start the app and follow the on-screen menu to interact with the shop manager.

## Contributing

Contributions are welcome! Please fork this repository and submit a pull request with your changes. Ensure your code adheres to the existing coding standards and includes relevant test cases.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

For any questions or feedback, feel free to reach out to the repository owner.
