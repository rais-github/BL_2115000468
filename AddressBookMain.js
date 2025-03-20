class Contact {
  constructor(
    firstName,
    lastName,
    address,
    city,
    state,
    zip,
    phoneNumber,
    email
  ) {
    this.validateContact(
      firstName,
      lastName,
      address,
      city,
      state,
      zip,
      phoneNumber,
      email
    );
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  validateContact(
    firstName,
    lastName,
    address,
    city,
    state,
    zip,
    phoneNumber,
    email
  ) {
    const namePattern = /^[A-Z][a-zA-Z]{2,}$/;
    const addressPattern = /^.{4,}$/;
    const zipPattern = /^\d{5}$/;
    const phonePattern = /^\d{3}-\d{4}$/;
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (!namePattern.test(firstName)) {
      throw new Error("Invalid first name");
    }
    if (!namePattern.test(lastName)) {
      throw new Error("Invalid last name");
    }
    if (!addressPattern.test(address)) {
      throw new Error("Invalid address");
    }
    if (!addressPattern.test(city)) {
      throw new Error("Invalid city");
    }
    if (!addressPattern.test(state)) {
      throw new Error("Invalid state");
    }
    if (!zipPattern.test(zip)) {
      throw new Error("Invalid zip code");
    }
    if (!phonePattern.test(phoneNumber)) {
      throw new Error("Invalid phone number");
    }
    if (!emailPattern.test(email)) {
      throw new Error("Invalid email address");
    }
  }

  toString() {
    return `Contact: 
        First Name: ${this.firstName}
        Last Name: ${this.lastName}
        Address: ${this.address}
        City: ${this.city}
        State: ${this.state}
        Zip: ${this.zip}
        Phone Number: ${this.phoneNumber}
        Email: ${this.email}`;
  }
}

class AddressBook {
  constructor() {
    this.contacts = [];
  }

  addContact(contact) {
    this.contacts.push(contact);
  }

  getNumberOfContacts() {
    return this.contacts.length;
  }

  searchByCity(city) {
    return this.contacts.filter((contact) => contact.city === city);
  }

  searchByState(state) {
    return this.contacts.filter((contact) => contact.state === state);
  }
}

let addressBook = new AddressBook();
let contact1 = new Contact(
  "John",
  "Doe",
  "123 Main St",
  "Springfield",
  "IL",
  "62704",
  "555-1234",
  "john.doe@example.com"
);
let contact2 = new Contact(
  "Jane",
  "Doe",
  "456 Elm St",
  "Springfield",
  "IL",
  "62704",
  "555-5678",
  "jane.doe@example.com"
);

addressBook.addContact(contact1);
addressBook.addContact(contact2);

console.log(`Number of contacts: ${addressBook.getNumberOfContacts()}`);
console.log(contact1.toString());
console.log(contact2.toString());

console.log("Contacts in Springfield:");
addressBook
  .searchByCity("Springfield")
  .forEach((contact) => console.log(contact.toString()));

console.log("Contacts in IL:");
addressBook
  .searchByState("IL")
  .forEach((contact) => console.log(contact.toString()));

export { Contact, AddressBook };
