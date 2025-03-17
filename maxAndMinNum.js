function getRandomThreeDigitNumber() {
  return Math.floor(Math.random() * 900) + 100;
}

let numbers = [];
for (let i = 0; i < 5; i++) {
  numbers.push(getRandomThreeDigitNumber());
}

let maxNumber = Math.max(...numbers);
let minNumber = Math.min(...numbers);

console.log("Random 3-digit numbers: ", numbers);
console.log("Maximum value: ", maxNumber);
console.log("Minimum value: ", minNumber);
