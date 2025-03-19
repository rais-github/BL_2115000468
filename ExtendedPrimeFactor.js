function primeFactors(n) {
  const factors = [];
  while (n % 2 === 0) {
    factors.push(2);
    n = n / 2;
  }

  for (let i = 3; i <= Math.sqrt(n); i += 2) {
    while (n % i === 0) {
      factors.push(i);
      n = n / i;
    }
  }

  if (n > 2) {
    factors.push(n);
  }

  return factors;
}

const number = 315;
const result = primeFactors(number);
console.log(`Prime factors of ${number} are: ${result}`);
