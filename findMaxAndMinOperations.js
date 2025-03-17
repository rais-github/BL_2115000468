const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.question("Enter the first number (a): ", (a) => {
  rl.question("Enter the second number (b): ", (b) => {
    rl.question("Enter the third number (c): ", (c) => {
      a = parseFloat(a);
      b = parseFloat(b);
      c = parseFloat(c);

      const result1 = a + b * c;
      const result2 = (a % b) + c;
      const result3 = c + a / b;
      const result4 = a * b + c;

      const results = [result1, result2, result3, result4];

      const max = Math.max(...results);
      const min = Math.min(...results);

      console.log(`Results: ${results}`);
      console.log(`Maximum value: ${max}`);
      console.log(`Minimum value: ${min}`);

      rl.close();
    });
  });
});
