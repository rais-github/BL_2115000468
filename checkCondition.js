const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

// Function to check if a number is prime
function isPrime(num) {
  if (num <= 1) return false;
  for (let i = 2; i <= Math.sqrt(num); i++) {
    if (num % i === 0) return false;
  }
  return true;
}

// Function to get the palindrome of a number
function getPalindrome(num) {
  return parseInt(num.toString().split("").reverse().join(""));
}

// Main function to check the conditions
function checkNumber(num) {
  if (isPrime(num)) {
    const palindrome = getPalindrome(num);
    if (isPrime(palindrome)) {
      console.log(
        `The number ${num} is prime and its palindrome ${palindrome} is also prime.`
      );
    } else {
      console.log(
        `The number ${num} is prime but its palindrome ${palindrome} is not prime.`
      );
    }
  } else {
    console.log(`The number ${num} is not prime.`);
  }
}

// Take input from user
rl.question("Enter a number: ", (answer) => {
  const num = parseInt(answer);
  checkNumber(num);
  rl.close();
});
