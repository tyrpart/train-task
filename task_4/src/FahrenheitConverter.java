public class FahrenheitConverter implements Converter{
    @Override
    public double getConvertedValue(double celsiusValue) {
        return celsiusValue * 1.8 + 32;
    }
}
