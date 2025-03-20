class EmployeePayroll {
  constructor(id, name, salary, gender, startDate) {
    this.id = id;
    this.setName(name); // Use the setter to validate the name
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
    const namePattern = /^[A-Z][a-zA-Z]{2,}$/;
    if (!namePattern.test(name)) {
      throw new Error(
        "Name must start with a capital letter and have at least 3 characters."
      );
    }
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

try {
  const employee = new EmployeePayroll(
    1,
    "John Doe",
    50000,
    "Male",
    new Date()
  );
  console.log(employee.getId()); // 1
  console.log(employee.getName()); // John Doe
  console.log(employee.getSalary()); // 50000
  console.log(employee.getGender()); // Male
  console.log(employee.getStartDate()); // Current date
} catch (error) {
  console.error(error.message);
}

try {
  const employee = new EmployeePayroll(2, "john", 50000, "Male", new Date());
} catch (error) {
  console.error(error.message);
}
