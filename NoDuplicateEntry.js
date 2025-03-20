import Contact from "./AddressBookMain";

class AddressBook {
  constructor() {
    this.contacts = [];
  }

  addContact(contact) {
    if (this.isDuplicate(contact)) {
      console.log("Duplicate entry found. Contact not added.");
    } else {
      this.contacts.push(contact);
      console.log("Contact added successfully.");
    }
  }

  isDuplicate(newContact) {
    return this.contacts.some((contact) => contact.name === newContact.name);
  }
}

const addressBook = new AddressBook();
const contact1 = new Contact(
  "John Doe",
  "123 Main St",
  "john@example.com",
  "555-555-5555"
);
const contact2 = new Contact(
  "Jane Doe",
  "456 Elm St",
  "jane@example.com",
  "555-555-5556"
);
const contact3 = new Contact(
  "John Doe",
  "789 Oak St",
  "john.doe@example.com",
  "555-555-5557"
);

addressBook.addContact(contact1);
addressBook.addContact(contact2);
addressBook.addContact(contact3);
