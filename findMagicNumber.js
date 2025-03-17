const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let low = 1;
let high = 100;

console.log("Think of a number between 1 and 100");

function askQuestion() {
  if (low === high) {
    console.log(`Your magic number is ${low}`);
    rl.close();
    return;
  }

  const mid = Math.floor((low + high) / 2);
  rl.question(
    `Is your number less than or equal to ${mid}? (yes/no): `,
    (answer) => {
      if (answer.toLowerCase() === "yes") {
        high = mid;
      } else {
        low = mid + 1;
      }
      askQuestion();
    }
  );
}

askQuestion();
