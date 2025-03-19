function rollDie() {
  return Math.floor(Math.random() * 6) + 1;
}

function rollDieUntilLimit(limit) {
  let dieRolls = { 1: 0, 2: 0, 3: 0, 4: 0, 5: 0, 6: 0 };
  let maxRolls = 0;

  while (maxRolls < limit) {
    let roll = rollDie();
    dieRolls[roll]++;
    maxRolls = Math.max(...Object.values(dieRolls));
  }

  return dieRolls;
}

function findMaxMin(dieRolls) {
  let maxRoll = { number: null, count: 0 };
  let minRoll = { number: null, count: Infinity };

  for (let number in dieRolls) {
    if (dieRolls[number] > maxRoll.count) {
      maxRoll.number = number;
      maxRoll.count = dieRolls[number];
    }
    if (dieRolls[number] < minRoll.count) {
      minRoll.number = number;
      minRoll.count = dieRolls[number];
    }
  }

  return { maxRoll, minRoll };
}

const limit = 10;
const dieRolls = rollDieUntilLimit(limit);
const { maxRoll, minRoll } = findMaxMin(dieRolls);

console.log("Die rolls:", dieRolls);
console.log("Number that reached maximum times:", maxRoll);
console.log("Number that reached minimum times:", minRoll);
