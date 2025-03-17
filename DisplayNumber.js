function displayPlaceValue(number) {
  switch (number) {
    case 1:
      console.log("Unit");
      break;
    case 10:
      console.log("Ten");
      break;
    case 100:
      console.log("Hundred");
      break;
    case 1000:
      console.log("Thousand");
      break;
    case 10000:
      console.log("Ten Thousand");
      break;
    case 100000:
      console.log("Hundred Thousand");
      break;
    case 1000000:
      console.log("Million");
      break;
    default:
      console.log("Invalid input");
  }
}

displayPlaceValue(1); // Output: Unit
displayPlaceValue(10); // Output: Ten
displayPlaceValue(100); // Output: Hundred
displayPlaceValue(1000); // Output: Thousand
displayPlaceValue(10000); // Output: Ten Thousand
displayPlaceValue(100000); // Output: Hundred Thousand
displayPlaceValue(1000000); // Output: Million
