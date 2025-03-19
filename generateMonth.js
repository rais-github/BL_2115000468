function generateBirthMonths() {
  const birthMonths = [];
  const individuals = 50;

  for (let i = 0; i < individuals; i++) {
    const month = Math.floor(Math.random() * 12) + 1;
    birthMonths.push(month);
  }

  const monthGroups = {};
  birthMonths.forEach((month, index) => {
    if (!monthGroups[month]) {
      monthGroups[month] = [];
    }
    monthGroups[month].push(index + 1);
  });

  for (const month in monthGroups) {
    console.log(`Month ${month}: Individuals ${monthGroups[month].join(", ")}`);
  }
}

generateBirthMonths();
