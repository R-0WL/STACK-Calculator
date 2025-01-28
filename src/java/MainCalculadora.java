/*
 * Universidad del valle 
 */

import java.util.*;
import java.io.*;

public class MainCalculadora{
  public static void main(String[] args) throws Exception{
    //Creación de objetos
    Stack<Integer> calcStack = new StackVector<Integer>();
    File datos = new File("datos.txt");
    Scanner scar = new Scanner(datos);

    String scarNext = scar.next();

    while(scar.hasNext()){ //While encargado de comprobar si hay elementos en datos
      for (int i = 0; i < scarNext.length()-1; i++){ //Encargado de ir operando cada fila del postfix
        /*
         * Declaración de un char para obtener solo un caracter a la vez
         * Num1 y Num2 encargados de guardar números variantes
         */
        char carac = scarNext.charAt(i);
        int num1 = 0;
        int num2 = 0;

        /*
         * Try catch en caso de que alguna operación no pueda ser realizada
         */
        try{
          if (Character.isDigit(carac)){ //Comprobación de si el caracter es un dígito
            calcStack.push(Character.getNumericValue(carac));

          }else{ //Para los que no sean caracteres
            switch (carac){
              case '+':
                num1 = calcStack.pop();
                num2 = calcStack.pop();
                calcStack.push(num1 + num2);
                System.out.println(i + ". " + calcStack.peek());
                break;

              case '-':
                num1 = calcStack.pop();
                num2 = calcStack.pop();
                calcStack.push(num1 - num2);
                System.out.println(i + ". " + calcStack.peek());
                break;

              case '*':
                num1 = calcStack.pop();
                num2 = calcStack.pop();
                calcStack.push(num1 * num2);
                System.out.println(i + ". " + calcStack.peek());
                break;

              case '/':
                num1 = calcStack.pop();
                num2 = calcStack.pop();
                calcStack.push(num1 / num2);
                System.out.println(i + ". " + calcStack.peek());
                break;
              }
            }
        }catch(IOException e){
          e.printStackTrace();
        }
      }
    }
    scar.close(); //Scanner cerrado
  }
}