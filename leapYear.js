function isLeapYear(year) {
  if (year.toString().length !== 4) {
    return "Please enter a 4 digit year.";
  }
  if ((year % 4 === 0 && year % 100 !== 0) || year % 400 === 0) {
    return "Year " + year + " is a Leap Year.";
  } else {
    return "Year " + year + " is not a Leap Year.";
  }
}

const year = 2024;
console.log(isLeapYear(year));
