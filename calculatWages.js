const PART_TIME_HOURS = 4;
const FULL_TIME_HOURS = 8;
const WAGE_PER_HOUR = 20;

function getWorkingHours(empCheck) {
  switch (empCheck) {
    case 0:
      return 0;
    case 1:
      return PART_TIME_HOURS;
    case 2:
      return FULL_TIME_HOURS;
    default:
      return 0;
  }
}

function calculateMonthlyWage() {
  let totalWage = 0;
  const WORKING_DAYS = 20;
  for (let day = 0; day < WORKING_DAYS; day++) {
    totalWage += calculateDailyWage();
  }
  return totalWage;
}

console.log("Monthly Wage: $" + calculateMonthlyWage());

function calculateDailyWage() {
  let empCheck = Math.floor(Math.random() * 3);
  let empHours = getWorkingHours(empCheck);
  let dailyWage = empHours * WAGE_PER_HOUR;
  return dailyWage;
}

console.log("Daily Wage: $" + calculateDailyWage());

function calculateWagesWithCondition() {
  let totalEmpHours = 0;
  let totalWorkingDays = 0;
  const MAX_HOURS_IN_MONTH = 160;
  const MAX_WORKING_DAYS = 20;

  while (
    totalEmpHours <= MAX_HOURS_IN_MONTH &&
    totalWorkingDays < MAX_WORKING_DAYS
  ) {
    totalWorkingDays++;
    let empCheck = Math.floor(Math.random() * 3);
    totalEmpHours += getWorkingHours(empCheck);
  }

  let totalWage = totalEmpHours * WAGE_PER_HOUR;
  return totalWage;
}

console.log("Total Wage with Condition: $" + calculateWagesWithCondition());
