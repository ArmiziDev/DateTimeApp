# DateTimePlus
This project is an Android application that allows users to manipulate the current date and time by adding specific time units such as hours, days, weeks, or months to it. The application dynamically updates the UI based on the device's orientation and preserves the user's inputs and results when the app state is restored.

## Features
- Date and Time Manipulation: Users can input a value and select a time unit (hours, days, weeks, or months) to add to the current date and time.
- Dynamic Orientation Support: The app layout adjusts for both portrait and landscape orientations.
- State Preservation: The app saves the user's input and history when the app state changes (e.g., screen rotation or backgrounding) and restores it when the user returns.
- History of Calculations: Each time the user adds time, the result is displayed and saved to a scrollable list for easy reference.
- Clear Functionality: Users can clear the history of calculations with a single button.
- ![image](https://github.com/user-attachments/assets/ab2c4ae3-c112-40b3-818a-1228dd6685b0)
- ![image](https://github.com/user-attachments/assets/8cf1d55c-baa9-45b8-91ba-89e551a8c1ca)

  
## How to Use
- Input a Value: Enter a numerical value in the input field.
- Select a Time Unit: Choose from hours, days, weeks, or months.
- Calculate: Press the "Calculate" button to add the selected amount of time to the current date.
- View Result: The updated date and time will be displayed in the result field, and the operation will be saved in the history list.
- Clear History: Press the "Clear" button to remove all previous results.
  
## What I Learned
Through this project, I developed my skills in:

- Android UI Design: Managing UI components dynamically and adapting layouts for different orientations (portrait vs. landscape).
- State Management: Handling the saving and restoring of the application state using onSaveInstanceState and onRestoreInstanceState to preserve user input and results.
- Time and Date Handling: Working with the Calendar class to perform date and time calculations.
- RadioGroup and Event Handling: Managing user inputs through radio buttons and executing actions based on selections.
- Edge-to-Edge UI Design: Implementing edge-to-edge layouts to make use of the full screen and handle window insets.
  
## Code Highlights
- State Preservation: The onSaveInstanceState and onRestoreInstanceState methods ensure that the application retains user data and state across orientation changes and app lifecycle events.
- Dynamic UI Layout: The app loads different layouts depending on the device's orientation, ensuring an optimized user experience.
- Calendar Manipulation: The app makes use of the Calendar class to add time units and display the updated date and time.

### Installation
To run this project:
1. Clone this repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or a physical Android device.
