import { Contact } from "./AddressBookMain";

function searchByCity(contacts, city) {
  return contacts.filter((contact) => contact.city === city);
}

function searchByState(contacts, state) {
  return contacts.filter((contact) => contact.state === state);
}

export { searchByCity, searchByState };
