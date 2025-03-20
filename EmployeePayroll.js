class EmployeePayroll {
  constructor(id, name, salary, gender, startDate, pincode, email) {
    this.id = id;
    this.setName(name); // Use the setter to validate the name
    this.salary = salary;
    this.gender = gender;
    this.startDate = startDate;
    this.setPincode(pincode); // Use the setter to validate the pincode
    this.setEmail(email); // Use the setter to validate the email
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

  getPincode() {
    return this.pincode;
  }

  getEmail() {
    return this.email;
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

  setPincode(pincode) {
    const pincodePattern = /^[1-9][0-9]{5}$/;
    if (!pincodePattern.test(pincode)) {
      throw new Error(
        "Pincode must be a 6 digit number starting with a non-zero digit."
      );
    }
    this.pincode = pincode;
  }

  setEmail(email) {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(email)) {
      throw new Error("Invalid email format.");
    }
    this.email = email;
  }
}

try {
  const employee = new EmployeePayroll(
    1,
    "John Doe",
    50000,
    "Male",
    new Date(),
    "123456",
    "john.doe@example.com"
  );
  console.log(employee.getId()); // 1
  console.log(employee.getName()); // John Doe
  console.log(employee.getSalary()); // 50000
  console.log(employee.getGender()); // Male
  console.log(employee.getStartDate()); // Current date
  console.log(employee.getPincode()); // 123456
  console.log(employee.getEmail()); // john.doe@example.com
} catch (error) {
  console.error(error.message);
}

try {
  const employee = new EmployeePayroll(
    2,
    "john",
    50000,
    "Male",
    new Date(),
    "12345",
    "john.doe@com"
  );
} catch (error) {
  console.error(error.message); // Name must start with a capital letter and have at least 3 characters.
}
