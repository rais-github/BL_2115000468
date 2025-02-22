public class ValidateCreditCards {

    public static void main(String[] args) {
        String visaCard = "4123456789012345";
        String masterCard = "5123456789012345";

        System.out.println("Visa Card Valid: " + isValidVisa(visaCard));
        System.out.println("MasterCard Valid: " + isValidMasterCard(masterCard));
    }

    public static boolean isValidVisa(String cardNumber) {
        return cardNumber.matches("^4[0-9]{15}$");
    }

    public static boolean isValidMasterCard(String cardNumber) {
        return cardNumber.matches("^5[1-5][0-9]{14}$");
    }
}