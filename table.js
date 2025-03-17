const n = parseInt(process.argv[2]);

if (isNaN(n) || n < 0) {
  console.log("Please provide a non-negative integer as an argument.");
  process.exit(1);
}

console.log(`Powers of 2 less than or equal to 2^${n}:`);

for (let i = 0; i <= n; i++) {
  console.log(`2^${i} = ${Math.pow(2, i)}`);
}
