import org.mariuszgromada.math.mxparser.*;


public class Logic {
    public String output;

    public String solve(String text){
        text = text.replace(" ", "");
        text = text.replace("x", "*");

        if (text.length() != 0) {
            try {
                String a = text.replace("/", "");
                a = a.replace("sin", "");
                a = a.replace("cos", "");
                a = a.replace("tan", "");
                a = a.replace("*", "");
                a = a.replace("+", "");
                a = a.replace("-", "");
                a = a.replace("(", "");
                a = a.replace(")", "");
                Double num = Double.parseDouble(a);
            } catch (NumberFormatException e) {
                return "Math Error";
            }

            try {
                int index = text.indexOf("(");
                if (text.charAt(index - 1) != '(' && text.charAt(index - 1) != ')' && text.charAt(index - 1) != '+'
                        && text.charAt(index - 1) != '-' && text.charAt(index - 1) != '*' && text.charAt(index - 1) != '/') {
                    text = text.replace("(", "*(");
                }
            } catch (Exception e){}

            Expression e = new Expression(text);
            double result = e.calculate();

            output = String.valueOf(result);

            if (output == "NaN")
                output = "Math Error";

            return output;
        }

        return "";
    }
}
