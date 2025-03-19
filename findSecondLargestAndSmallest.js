function generateRandom3DigitNumber() {
  return Math.floor(100 + Math.random() * 900);
}

let randomNumbers = [];
for (let i = 0; i < 10; i++) {
  randomNumbers.push(generateRandom3DigitNumber());
}

console.log("Random Numbers: ", randomNumbers);

function findSecondLargestAndSmallest(arr) {
  let firstLargest = -Infinity,
    secondLargest = -Infinity;
  let firstSmallest = Infinity,
    secondSmallest = Infinity;

  for (let num of arr) {
    if (num > firstLargest) {
      secondLargest = firstLargest;
      firstLargest = num;
    } else if (num > secondLargest && num !== firstLargest) {
      secondLargest = num;
    }

    if (num < firstSmallest) {
      secondSmallest = firstSmallest;
      firstSmallest = num;
    } else if (num < secondSmallest && num !== firstSmallest) {
      secondSmallest = num;
    }
  }

  return {
    secondLargest: secondLargest,
    secondSmallest: secondSmallest,
  };
}

let result = findSecondLargestAndSmallest(randomNumbers);
console.log("Second Largest: ", result.secondLargest);
console.log("Second Smallest: ", result.secondSmallest);
