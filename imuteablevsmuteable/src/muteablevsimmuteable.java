
public class muteablevsimmuteable {

    public static void main(String[] args) {
        // Strings in java are always immutable
        // in other languages like c+ a string can be mutable and you can mordify him directly
        String first = "first";
        System.out.println(first.hashCode());
        //everytime a String is changed it creates a new and seperate copy
        first = first +"!";

        System.out.println(first.hashCode());

        //if u want a mutable string in java you caqn use the string builder object
        StringBuilder mutableString = new StringBuilder("mutable?");
        System.out.println(mutableString);
        mutableString.setCharAt(2,'!');
        String imumutableString = mutableString.toString();
        System.out.println(imumutableString.hashCode());

        String s1= "java";
        s1.concat("rules");
        //s1 still refers to "java"
        //Why ?
        // The first line is pretty straightforward: create new String "java" and refer s1 to it
        // Next the VM creates another4 new String "java rules", but nothing refers to it. SO the second String is instantlya lose. We cant't reach it.
        System.out.println(s1);
        String s2 = s1.concat("rules");
        System.out.println(s2);
        // Heap: A String bool Area is existing
        //1
        String str = new String("very");

        //2
        str = "good";
        // THe first line is existing in the Heap area. Also a string with the same value will be created in the string pool but the variable will point to string object in heap area only
        // The second Line will be created in the string pooled area
        // if we again write a str = new String("very") then it will create a new object with the value "very" rather then pointing to the available object in heap area with the same value. But if
        // we write str="very" then it will pont to String constant object with value "very" present in String pooled area

    }
}
