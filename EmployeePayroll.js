class EmployeePayroll {
  constructor(id, name, salary, gender, startDate) {
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.gender = gender;
    this.startDate = startDate;
  }

  getId() {
    return this.id;
  }

  getName() {
    return this.name;
  }

  getSalary() {
    return this.salary;
  }

  getGender() {
    return this.gender;
  }

  getStartDate() {
    return this.startDate;
  }

  setId(id) {
    this.id = id;
  }

  setName(name) {
    this.name = name;
  }

  setSalary(salary) {
    this.salary = salary;
  }

  setGender(gender) {
    this.gender = gender;
  }

  setStartDate(startDate) {
    this.startDate = startDate;
  }
}

const employee = new EmployeePayroll(1, "John Doe", 50000, "Male", new Date());
console.log(employee.getId()); // 1
console.log(employee.getName()); // John Doe
console.log(employee.getSalary()); // 50000
console.log(employee.getGender()); // Male
console.log(employee.getStartDate()); // Current date
