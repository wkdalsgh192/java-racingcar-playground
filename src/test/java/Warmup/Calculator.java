package Warmup;

class Calculator {

    public int calc(String input) {
        if (input == null || "".equals(input)) return 0;

        PatternUtils utils = PatternUtils.create(input);
        if (utils.find()) {
            return add(utils.getValue(), utils.getDelimiter());
        }
        return add(input, "[,:]");
    }

    private int add(String input, String regex) {
        Number number = new Number();
        String[] arrays = input.split(regex);
        for (String s : arrays) {
            number.add(new Number(Integer.parseInt(s)));
        }
        return number.getNumericValue();
    }

}
