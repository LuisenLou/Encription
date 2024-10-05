
import java.util.HashMap;
import java.util.Scanner;

public class criptocode {

    private static final int KEY = 6;
    private static HashMap<String, String> cipherBoard = new HashMap<>();

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        while(true){
            try{
                
                System.out.println("--- Sistema de Cifrado de Mensajería ---");
                System.out.println("1. Cifrar un mensaje");
                System.out.println("2. Mostrar mensajes cifrados");
                System.out.println("3. Descifrar un mensaje");
                System.out.println("4. Salir");
                System.out.println("Seleccione una opción: ");
                String option = scanner.nextLine();
                
                switch (option) {         
                    case "1":
                        System.out.println("Introduzca el texto a cifrar:");
                        String text = scanner.nextLine();
                        System.out.println("Introduzca una clave única para el texto:");
                        String textKey = scanner.nextLine();
                        String cipheredText = cipherMachine(text);
                        cipherBoard.put(textKey, cipheredText);
                        System.out.println(cipheredText);
                        break;

                    case "2":
                        if(cipherBoard.isEmpty()){
                            System.out.println("El banco de datos está vacío");
                        }else{
                            System.out.println("Mensajes en el banco de datos:");
                            for(String key: cipherBoard.keySet()){
                                System.out.println("Clave única: " + key + "\n"
                                + "Mensaje cifrado: " + cipherBoard.get(key) + ".\n");
                            }
                        }

                    break;

                    case "3":
                        if(cipherBoard.isEmpty()){
                            System.out.println("No hay textos cifrados en el almacen");
                        }else{
                            System.out.println("Introduzca la clave única del texto para descifrar");
                            String cipheredTextKey = scanner.nextLine();
                            
                            if(cipherBoard.containsKey(cipheredTextKey)){
                                String obtainedCipheredText = cipherBoard.get(cipheredTextKey);
                                String obtainedText = decipherMachine(obtainedCipheredText);
                                System.out.println("Texto cifrado: " + obtainedCipheredText);
                                System.out.println("Texto descifrado: " + obtainedText);
                            }else{
                                System.out.println("No existe un mensaje asociado a la clave en el banco de datos.");
                            }
                        }
                        break;
                
                    case "4": System.out.println("Saliendo del programa.");
                        scanner.close();
                        return;
                
                    default:
                        System.out.println("Por favor pulse un número del 1 al 4");
                        break;
                }
            }catch (Exception e){
                System.out.println("Ha ocurrido un error:"+ e.getMessage());
            }

    
        }
    }

    public static String cipherMachine (String text){
        
        StringBuilder cipherText = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            char noncipherChar = text.charAt(i);
            char cipherChar =(char)( noncipherChar + KEY);
            cipherText.append(cipherChar);
        }
        return cipherText.toString();
    }

    public static String decipherMachine (String text){
        StringBuilder decipherText = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            char cipherChar = text.charAt(i);
            char decipherChar = (char)( cipherChar - KEY);
            decipherText.append(decipherChar);
        }
        return decipherText.toString();
    }
}