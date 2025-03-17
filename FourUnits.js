const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function convertUnits(choice, value) {
  switch (choice) {
    case 1:
      return value * 12;
    case 2:
      return value * 0.3048;
    case 3:
      return value / 12;
    case 4:
      return value / 0.3048;
    default:
      return null;
  }
}

rl.question(
  "Choose conversion: 1. Feet to Inch 2. Feet to Meter 3. Inch to Feet 4. Meter to Feet\n",
  (choice) => {
    const conversionChoice = parseInt(choice);
    if (conversionChoice < 1 || conversionChoice > 4) {
      console.log("Invalid choice");
      rl.close();
      return;
    }

    rl.question("Enter the value to convert: ", (value) => {
      const inputValue = parseFloat(value);
      if (isNaN(inputValue)) {
        console.log("Invalid value");
        rl.close();
        return;
      }

      const result = convertUnits(conversionChoice, inputValue);
      console.log(`Converted value: ${result}`);
      rl.close();
    });
  }
);
