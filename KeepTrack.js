class Gambler {
  constructor(startingAmount, goal) {
    this.money = startingAmount;
    this.goal = goal;
    this.bets = 0;
    this.wins = 0;
  }

  play() {
    while (this.money > 0 && this.money < this.goal) {
      this.bets++;
      if (Math.random() < 0.5) {
        this.money++;
        this.wins++;
      } else {
        this.money--;
      }
    }
  }

  getResults() {
    return {
      money: this.money,
      bets: this.bets,
      wins: this.wins,
    };
  }
}

const gambler = new Gambler(100, 200);
gambler.play();
const results = gambler.getResults();

console.log(`Final money: Rs ${results.money}`);
console.log(`Total bets made: ${results.bets}`);
console.log(`Total wins: ${results.wins}`);
