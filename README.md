## Fast Food Restaurant Simulation - Concurrency & GUI Practice

This project was developed as a practice exercise to understand and implement **concurrency** and **GUI programming** in Java.

### Concept
The simulation models the cooking process of various dishes in a fast food restaurant while considering multiple factors, including:

- **Staff:**  
  Employees have different skill levels and varying experience in preparing different dishes, affecting their speed.

- **Dishes:**  
  Each dish requires specific ingredients, tools, and preparation time.

- **Orders:**  
  Orders consist of multiple dishes, all of which need to be completed together.

### Graphical User Interface (GUI)
The GUI allows users to place orders, with a limit on how many can be processed simultaneously. Ongoing orders are displayed in real time as they are prepared.

### Concurrency Challenges
The simulation incorporates concurrency by allowing staff members to work in parallel, while ensuring:
- **Resource management:** Tools and machines can only be used for one dish at a time.
- **Thread safety:** Ingredients and equipment usage are properly managed to prevent inconsistencies, a common issue in concurrent programming.

### Project Scope
While additional factors could have been considered, the goal was to keep the project focused on practicing concurrency without unnecessary complexity.

### Why JavaFX?
JavaFX was chosen for the GUI as it was the primary framework known at the time. However, since JavaFX is not widely used in the industry, completing the project was ultimately deemed unnecessary.

This project was created for **exam preparation** and remains unfinished.
