package loginScreen;

import org.testng.annotations.Factory;

public class FactoryPatterns {

    @Factory
    public Object[] factoryMethod() {
        return new Object[] {
                new SampleLoginTest("chrome"),
                new SampleLoginTest("firefox"),
                new SampleLoginTest("edge")};
    }
}
