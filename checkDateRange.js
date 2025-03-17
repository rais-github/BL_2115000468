const args = process.argv.slice(2);

if (args.length !== 2) {
  console.log("Please provide both day and month as arguments.");
  process.exit(1);
}

const day = parseInt(args[0]);
const month = parseInt(args[1]);

if (isNaN(day) || isNaN(month)) {
  console.log(
    "Invalid input. Please provide numeric values for day and month."
  );
  process.exit(1);
}

const isInRange =
  (month === 3 && day >= 20) ||
  month === 4 ||
  month === 5 ||
  (month === 6 && day <= 20);

console.log(isInRange);
