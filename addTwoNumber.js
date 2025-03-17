function rollDice() {
  return Math.floor(Math.random() * 6) + 1;
}

const dice1 = rollDice();
const dice2 = rollDice();

const sum = dice1 + dice2;

console.log(`Dice 1: ${dice1}, Dice 2: ${dice2}, Sum: ${sum}`);
