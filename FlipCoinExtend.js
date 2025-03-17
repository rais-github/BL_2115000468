function flipCoin() {
  return Math.random() < 0.5 ? "Heads" : "Tails";
}

let headsCount = 0;
let tailsCount = 0;
const winningCount = 11;

while (headsCount < winningCount && tailsCount < winningCount) {
  const result = flipCoin();
  if (result === "Heads") {
    headsCount++;
  } else {
    tailsCount++;
  }
  console.log(`Result: ${result}, Heads: ${headsCount}, Tails: ${tailsCount}`);
}

if (headsCount === winningCount) {
  console.log("Heads wins!");
} else {
  console.log("Tails wins!");
}
