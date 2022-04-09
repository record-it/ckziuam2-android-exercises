package pl.zsl.androidapp.calculator;

public class Register {
    private String strValue = "0";

    public boolean add(char symbol){
        if (strValue.equals("0") && symbol != '.'){
            strValue = "" + symbol;
            return true;
        } else{
            if (strValue.contains(".") && symbol == '.'){
                return false;
            }
            strValue = strValue + symbol;
            return true;
        }
    }

    public boolean backspace(){
        if (strValue.length() > 0){
            strValue = strValue.substring(0, strValue.length() - 1);
            if (strValue.length() == 0){
                strValue = "0";
            }
            return true;
        }
        return false;
    }

    public String getStrValue(){
        return strValue;
    }

    public double getValue(){
        return Double.parseDouble(strValue);
    }

    public void clear(){
        strValue = "0";
    }

}
