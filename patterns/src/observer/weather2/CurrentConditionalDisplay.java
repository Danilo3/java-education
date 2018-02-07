package observer.weather2;

import observer.weather.DisplayElement;

import observer.weather2.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionalDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    Observable observable;

    public CurrentConditionalDisplay(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions:  "+ temperature + "F degrees and "+ humidity + "% humidity" );

    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity =weatherData.getHumidity();
            display();
        }
    }
}
