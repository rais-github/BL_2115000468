const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question(
  "Enter 1 to convert Celsius to Fahrenheit or 2 to convert Fahrenheit to Celsius: ",
  (choice) => {
    switch (choice) {
      case "1":
        rl.question("Enter temperature in Celsius: ", (degC) => {
          degC = parseFloat(degC);
          if (degC >= 0 && degC <= 100) {
            const degF = (degC * 9) / 5 + 32;
            console.log(`${degC}°C is equal to ${degF}°F`);
          } else {
            console.log("Temperature must be between 0°C and 100°C");
          }
          rl.close();
        });
        break;
      case "2":
        rl.question("Enter temperature in Fahrenheit: ", (degF) => {
          degF = parseFloat(degF);
          if (degF >= 32 && degF <= 212) {
            const degC = ((degF - 32) * 5) / 9;
            console.log(`${degF}°F is equal to ${degC}°C`);
          } else {
            console.log("Temperature must be between 32°F and 212°F");
          }
          rl.close();
        });
        break;
      default:
        console.log("Invalid choice. Please enter 1 or 2.");
        rl.close();
        break;
    }
  }
);
