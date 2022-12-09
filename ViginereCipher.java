import java.util.Scanner;
class ViginereCipher {
    private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encrypt(String message, String key){
        String cipherText = "";
        int Mi=0, Ki=0;
        for(int i=0; i<message.length(); i++){
            if(message.charAt(i) != ' '){
                Mi = alpha.indexOf(message.charAt(i));
                Ki = alpha.indexOf(key.charAt(i % key.length()));
                cipherText += alpha.charAt((Mi + Ki)%26);
            }
            else
                cipherText += " ";
        }        
        return cipherText;
    }
    public static String decrypt(String cipherText, String key){
        String plainText = "";
        int Ei = 0, Ki = 0;
        for(int i=0; i<cipherText.length(); i++){
            if(cipherText.charAt(i) != ' '){
                Ei = alpha.indexOf(cipherText.charAt(i));
                Ki = alpha.indexOf(key.charAt(i % key.length()));
                plainText += alpha.charAt((Ei - Ki + 26) % 26);
            }
            else
                plainText += " ";
        }
        return plainText;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a message to encrypt:");
        String message = scan.nextLine().toUpperCase();
        
        System.out.println("Enter a key:");
        String key = scan.next().toUpperCase();

        String cipherText = encrypt(message, key);
        System.out.println("The encrypted message is: " + cipherText);
        
        // System.out.println("Enter a cipherText:");
        // String encryptedMessage = scan.nextLine().toUpperCase();
        // System.out.println("Enter a key:");
        // String key = scan.next().toUpperCase();

        String plainText = decrypt(cipherText, key);
        System.out.println("The decrypted message is: "+ plainText);

        scan.close();
    }
}