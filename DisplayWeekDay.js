function getWeekDay(number) {
  const weekDays = [
    "Sunday",
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
  ];

  if (number < 0 || number > 6) {
    return "Invalid number. Please enter a number between 0 and 6.";
  }

  return weekDays[number];
}

const number = 3;
console.log(getWeekDay(number));
