import Contact from "./AddressBookMain";

class AddDataContact {
  constructor() {
    this.addressBook = [];
  }

  addContact(contact) {
    if (contact instanceof Contact) {
      this.addressBook.push(contact);
    } else {
      throw new Error("Invalid contact");
    }
  }
}

export default AddDataContact;
