class EmployeePayroll {
  constructor(id, name, salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
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

  setId(id) {
    this.id = id;
  }

  setName(name) {
    this.name = name;
  }

  setSalary(salary) {
    this.salary = salary;
  }
}

const employee = new EmployeePayroll(1, "John Doe", 50000);
console.log(employee.getId()); // 1
console.log(employee.getName()); // John Doe
console.log(employee.getSalary()); // 50000
