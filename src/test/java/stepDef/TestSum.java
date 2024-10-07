package stepDef;

public class TestSum {

    public static void main(String [] args){
        int sum = sumOfInteger("1073741823", "1073741825");
        System.out.println("Sum="+sum);
    }

    private static int sumOfInteger(String i1, String i2) {
        int num1 =0;
        int num2=0;
        try {
            num1 = Integer.parseInt(i1);
        } catch (Exception e){
            num1=-1;
        }

        try {
            num2 = Integer.parseInt(i2);
        } catch (Exception e){
            num2=-1;
        }

        if(i1.length()==0)
            num1=0;
        if (i2.length()==0)
            num2=0;
        return num1+num2;
    }
}
