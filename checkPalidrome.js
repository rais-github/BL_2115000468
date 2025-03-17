function isPalindrome(num) {
  const str = num.toString();
  const reversedStr = str.split("").reverse().join("");
  return str === reversedStr;
}

function checkPalindromes(num1, num2) {
  return isPalindrome(num1) && isPalindrome(num2);
}

const num1 = 121;
const num2 = 12321;
console.log(checkPalindromes(num1, num2));
