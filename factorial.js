function factorial(n) {
  if (n < 0) {
    return "Factorial is not defined for negative numbers";
  }
  if (n === 0 || n === 1) {
    return 1;
  }
  let result = 1;
  for (let i = 2; i <= n; i++) {
    result *= i;
  }
  return result;
}

const input = parseInt(prompt("Enter a number: "), 10);
if (!isNaN(input)) {
  console.log(`Factorial of ${input} is ${factorial(input)}`);
} else {
  console.log("Please enter a valid number");
}
