const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const weekDays = [
  "Sunday",
  "Monday",
  "Tuesday",
  "Wednesday",
  "Thursday",
  "Friday",
  "Saturday",
];

rl.question("Enter a number (0-6): ", (number) => {
  const dayIndex = parseInt(number);
  if (dayIndex >= 0 && dayIndex <= 6) {
    console.log(`The day is: ${weekDays[dayIndex]}`);
  } else {
    console.log("Please enter a valid number between 0 and 6.");
  }
  rl.close();
});
