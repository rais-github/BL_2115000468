function findSecondLargestAndSmallest(arr) {
  if (arr.length < 2) {
    throw new Error("Array must contain at least two elements");
  }

  arr.sort((a, b) => a - b);

  const secondSmallest = arr[1];

  const secondLargest = arr[arr.length - 2];

  return {
    secondSmallest,
    secondLargest,
  };
}

const array = [12, 35, 1, 10, 34, 1];
const result = findSecondLargestAndSmallest(array);
console.log(`Second Smallest: ${result.secondSmallest}`);
console.log(`Second Largest: ${result.secondLargest}`);
