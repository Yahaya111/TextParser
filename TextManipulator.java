/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textmanipulator;

/**
 *
 * @author HP 1
 */
public class TextManipulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TextManipulator manip = new TextManipulator();
        String result = manip.getFormattedUrl("Hello Sir, www.meme.com http://myurl.com Please click on the link www.example.com/confirmation?user1 and visit our website at www.example.com\n www.contoso.com");
        System.out.println("Final Text Result: "+result);
    }
    
    public String getFormattedUrl(String text){
       //split text into lines
        String[] textLines = text.split("\n");
        //parse through each word in a line and check for occurrence of url starting with (http:// or https:// or www.)
        StringBuilder sbWordsInLine = new StringBuilder();
        for(String s:textLines){
            String[] word = s.split(" ");
            int index = 0;
            for(String w:word){
                if(w.contains("http://"))
                {
                    word[index]="<a href=\""+word[index]+"\">"+word[index]+"</a>";
                    System.out.println(word[index]);
                }
                else if(w.contains("https://")){
                    word[index]="<a href=\""+word[index]+"\">"+word[index]+"</a>";
                    
                }
                else if(w.contains("www.")){
                    word[index]="<a href=\"http://"+word[index]+"\">"+word[index]+"</a>";
                    
                }
                sbWordsInLine.append(word[index]).append(" ");
                index++;
            }
            sbWordsInLine.append("\n");
        }
        
        return sbWordsInLine.toString();
    }
    
}
