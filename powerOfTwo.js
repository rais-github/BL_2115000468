const n = parseInt(process.argv[2]);

if (isNaN(n) || n < 0) {
  console.log("Please provide a non-negative integer as the argument.");
  process.exit(1);
}

console.log("Powers of 2 up to 2^" + n + " or 256:");

for (let i = 0; i <= n; i++) {
  let powerOfTwo = Math.pow(2, i);
  if (powerOfTwo > 256) break;
  console.log("2^" + i + " = " + powerOfTwo);
}
