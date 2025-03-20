import Contact from "./AddressBookMain";

function removeUser(name) {
  const index = Contact.findIndex((contact) => contact.name === name);
  if (index !== -1) {
    Contact.splice(index, 1);
    console.log(`User ${name} removed successfully.`);
  } else {
    console.log(`User ${name} not found.`);
  }
}

export default removeUser;
