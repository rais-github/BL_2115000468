const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Enter a single digit number: ", (number) => {
  switch (number) {
    case "0":
      console.log("Zero");
      break;
    case "1":
      console.log("One");
      break;
    case "2":
      console.log("Two");
      break;
    case "3":
      console.log("Three");
      break;
    case "4":
      console.log("Four");
      break;
    case "5":
      console.log("Five");
      break;
    case "6":
      console.log("Six");
      break;
    case "7":
      console.log("Seven");
      break;
    case "8":
      console.log("Eight");
      break;
    case "9":
      console.log("Nine");
      break;
    default:
      console.log("Please enter a valid single digit number.");
  }
  rl.close();
});
