import org.mariuszgromada.math.mxparser.*;


public class Logic {
    public String output;

    private String trigRatiosFormatting(String text, int Ind){
        String substring = text.substring(text.indexOf(")", Ind));

        String s = text.substring(0, text.indexOf(")", Ind)) + "*[deg]" + substring;
        try {
            if (text.charAt(Ind - 1) != 'c') {
                String trig = s;
                return trig;
            }
        } catch (Exception e){
            String trig = s;
            return trig;
        }
        
        return text;
    }

    private String inverseTrigRatiosFormatting(String text, int Ind){
        String substring = text.substring(text.indexOf(")", Ind));
        String trig =  text.substring(0, Ind) + "deg(" + text.substring(Ind, text.indexOf(")", Ind)) + ")" + substring;
        return trig;
    }

    private String checkInput(String text){
        try {
            String a = text.replace("/", "");
            a = a.replace("^", "");
            a = a.replace("pi", "");
            a = a.replace("e", "");
            a = a.replace("log", "");
            a = a.replace("ln", "");
            a = a.replace("abs", "");
            a = a.replace("sqrt", "");
            a = a.replace("arcsin", "");
            a = a.replace("arccos", "");
            a = a.replace("arctan", "");
            a = a.replace("sin", "");
            a = a.replace("cos", "");
            a = a.replace("tan", "");
            a = a.replace("*", "");
            a = a.replace("+", "");
            a = a.replace("-", "");
            a = a.replace("(", "");
            a = a.replace(")", "");
            Double num = Double.parseDouble(a);
            return text;
        } catch (NumberFormatException e) {
            return "Math Error";
        }
    }

    public String solve(String text){
        text = text.replace(" ", "");
        text = text.replace("x", "*");

        text = text.replace("π", "pi");


        if (text.length() != 0) {
            if (checkInput(text) == "Math Error") {
                System.out.println(text);
                return "Math Error";
            }

            int brIndex = text.indexOf("(");
            if (brIndex > 0)
                if (text.charAt(brIndex - 1) != '(' && text.charAt(brIndex - 1) != ')' && text.charAt(brIndex - 1) != '+'
                        && text.charAt(brIndex - 1) != '-' && text.charAt(brIndex - 1) != '*' && text.charAt(brIndex - 1) != '/'
                        && text.charAt(brIndex - 1) != 'n' && text.charAt(brIndex - 1) != 's' && text.charAt(brIndex - 1) != 't'
                        && text.charAt(brIndex - 3) != 'g' && text.charAt(brIndex - 1) != 'n') {
                    text = text.replace("(", "*(");
                }

            if (text.contains("arcsin(")) text = inverseTrigRatiosFormatting(text, text.indexOf("arcsin("));
            if (text.contains("arccos(")) text = inverseTrigRatiosFormatting(text, text.indexOf("arccos("));
            if (text.contains("arctan(")) text = inverseTrigRatiosFormatting(text, text.indexOf("arctan("));

            if (text.contains("sin(")) text = trigRatiosFormatting(text, text.indexOf("sin("));
            if (text.contains("cos(")) text = trigRatiosFormatting(text, text.indexOf("cos("));
            if (text.contains("tan(")) text = trigRatiosFormatting(text, text.indexOf("tan("));



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
