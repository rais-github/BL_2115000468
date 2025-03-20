import Contact from "./AddressBookMain";

class FindContact {
  constructor(addressBook) {
    this.addressBook = addressBook;
  }

  findContactByName(name) {
    return this.addressBook.find((contact) => contact.name === name);
  }

  editContact(name, newDetails) {
    const contact = this.findContactByName(name);
    if (contact) {
      Object.assign(contact, newDetails);
      return true;
    }
    return false;
  }
}

export default FindContact;
