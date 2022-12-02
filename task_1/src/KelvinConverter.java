public class KelvinConverter implements Converter{
    @Override
    public double getConvertedValue(double celsiusValue) {
        return celsiusValue + 273.15;
    }
}
