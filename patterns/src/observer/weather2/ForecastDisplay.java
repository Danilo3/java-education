package observer.weather2;


import observer.weather.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

    private float lastPressure;
    private float currentPressure;
    Observable observable;

    public ForecastDisplay(Observable observable){
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData =(WeatherData)o;
            lastPressure =currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Forecast conditions:  "+ lastPressure + " last pressure and "+ currentPressure + " current pressure" );

    }
}
