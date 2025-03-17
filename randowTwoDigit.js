function getRandomTwoDigit() {
  return Math.floor(Math.random() * 90) + 10;
}

let values = [];
for (let i = 0; i < 5; i++) {
  values.push(getRandomTwoDigit());
}

let sum = values.reduce((acc, val) => acc + val, 0);

let average = sum / values.length;

console.log("Random Two-Digit Values: ", values);
console.log("Sum: ", sum);
console.log("Average: ", average);
