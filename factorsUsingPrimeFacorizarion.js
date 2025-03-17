function primeFactors(n) {
  const factors = [];
  // Divide by 2 until n is odd
  while (n % 2 === 0) {
    factors.push(2);
    n = n / 2;
  }
  // n must be odd at this point, so we can skip even numbers
  for (let i = 3; i <= Math.sqrt(n); i += 2) {
    while (n % i === 0) {
      factors.push(i);
      n = n / i;
    }
  }
  // This condition is to check if n is a prime number greater than 2
  if (n > 2) {
    factors.push(n);
  }
  return factors;
}

function computeFactorsUsingPrimeFactorization(n) {
  const primeFactorsList = primeFactors(n);
  const factorsSet = new Set([1, n]);

  // Generate all factors from prime factors
  const generateFactors = (currentProduct, index) => {
    if (index === primeFactorsList.length) {
      factorsSet.add(currentProduct);
      return;
    }
    generateFactors(currentProduct, index + 1);
    generateFactors(currentProduct * primeFactorsList[index], index + 1);
  };

  generateFactors(1, 0);
  return Array.from(factorsSet).sort((a, b) => a - b);
}

// Example usage:
const number = 60;
console.log(
  `Factors of ${number} are:`,
  computeFactorsUsingPrimeFactorization(number)
);
