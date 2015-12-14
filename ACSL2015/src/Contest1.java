
import java.util.ArrayList;
import java.util.Scanner;


public class Contest1 {

    public static Scanner qwe;
    
    
    static String[] poss = {
        "---","--x","-w-","-wx","r--","r-x","rw-","rwx"
    };
    
    public static void firstI(){
        ArrayList<Integer> list = new ArrayList();
        String in = qwe.nextLine();
        System.out.println("");
        String[] temp = in.split(" ");
        for (int i = 0; i < temp.length; i++) {
            list.add(Integer.parseInt(temp[i]));
        }
        ArrayList<String> binaryList = tenToBin(list);
        for (int i = 0; i < binaryList.size(); i++) {
            System.out.print(binaryList.get(i)+" ");
        }
            
        
        System.out.print("and "+tenToCH(list));
        System.out.println("");
         
    }
    
    public static ArrayList<String> tenToBin(ArrayList<Integer> list){
        ArrayList<String> binaryList = new ArrayList();
        String ans = "";
        for (int i = 0; i < list.size(); i++) {
            binaryList.add(Integer.toBinaryString(list.get(i)));
            if (binaryList.get(i).length()==1) {
                binaryList.set(i, ("00"+binaryList.get(i)));
            }
            else if(binaryList.get(i).length()==2){
                 binaryList.set(i, ("0"+binaryList.get(i)));
            }
            ans+=(binaryList.get(i)+" ");
            
        }
        return binaryList;
    }
    
    public static String tenToCH(ArrayList<Integer> list){
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
            temp+=(poss[list.get(i)]+" ");
        }   
        return temp;
    }
    
    public static String binToCH(ArrayList<String> list){
        String temp = "";
        for (int i = 0; i < list.size(); i++) {
           int index = Integer.parseInt(list.get(i), 2);
            //System.out.println("INDEX:     "+index);
           temp+=poss[index]+" ";
        }
        return temp;
    }
    
    public static String binToOct(ArrayList<String> list){
        String tempString = "";
        for (int i = 0; i < list.size(); i++) {
            int tempInt=0;
           
                
                if (list.get(i).substring(0,1).equals("1")) {
                    tempInt+=4;
                }
                if (list.get(i).substring(1,2).equals("1")) {
                    tempInt+=2;
                }
                if (list.get(i).substring(2).equals("1")) {
                    tempInt+=1;
                }
                
            
            tempString+=tempInt+"";
        }
        return tempString;
    }
    
    public static void thirdI(){
        ArrayList<String> list = new ArrayList();
        String in = qwe.nextLine();
        String[] temp = in.split(" ");
        for (int i = 0; i < temp.length; i++) {
            list.add(temp[i]);
        }
        System.out.println("");
        System.out.print(binToOct(list)+" and ");
        System.out.print(binToCH(list));
        System.out.println("");
        
    }
    
    public static void fifthI(){
        String in = qwe.nextLine();
        String[] temp = in.split(" ");
        ArrayList<Integer> toConvToBin = new ArrayList();
       
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < poss.length; j++) {
                if (temp[i].equals(poss[j])) {
                    toConvToBin.add(j);
                }
            }
        }
         ArrayList<String> binList = tenToBin(toConvToBin);
         System.out.println("");
         System.out.print(binToOct(binList)+" and ");
         for (int i = 0; i < binList.size(); i++) {
             System.out.print(binList.get(i)+" ");
        }
         System.out.println("");
    }
    
    public static void main(String[] args) {
       qwe = new Scanner(System.in);
       Inter();
       Advance();
    }
    
    public static void Inter(){
       firstI();
       firstI();
       thirdI();
       thirdI();
       fifthI();
    }
    
    
    public static void solve(){
        String in = qwe.nextLine();
        String[] input = in.split(" ");
        String specialNum = input[0];
        ArrayList<Integer> numbersInt = new ArrayList();
        for (int i = 1; i < input.length; i++) {
            numbersInt.add(Integer.parseInt(input[i]));
        }
        
        String[] CH = tenToCH(numbersInt).split(" ");
        ArrayList<String> binaryList =  tenToBin(numbersInt);
        
        if (specialNum.equals("1")&&!CH[0].substring(2).equals("-")) {
            CH[0] = CH[0].substring(0,2)+"s";
        }
        if (specialNum.equals("2")&&!CH[1].substring(2).equals("-")) {
            CH[1] = CH[1].substring(0,2)+"s";
        }
        if (specialNum.equals("4")&&!CH[2].substring(2).equals("-")) {
            CH[2] = CH[2].substring(0,2)+"t";
        }
        
        System.out.println("");
        for (int i = 0; i < binaryList.size(); i++) {
            System.out.print(binaryList.get(i)+" ");
        }
        System.out.print("and ");
        for (int i = 0; i < CH.length; i++) {
            System.out.print(CH[i]+" ");
        }
        System.out.println("");
        
    }
    
    public static void Advance(){
        for (int i = 0; i < 5; i++) {
            solve();
        }
    }
    
}
