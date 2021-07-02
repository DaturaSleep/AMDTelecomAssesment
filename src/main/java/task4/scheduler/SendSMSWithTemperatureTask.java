package main.java.task4.scheduler;

import main.java.task4.phone.RouteeSendSMS;
import main.java.task4.phone.SendSMS;
import main.java.task4.weather.TemperatureGathererOpenWeatherImpl;

import java.util.TimerTask;

/**
 * SendSMSWithTemperatureTask class
 * class that represents TimerTask
 */
public class SendSMSWithTemperatureTask extends TimerTask {
    private static final SendSMS SEND_SMS = new RouteeSendSMS();
    private static final TemperatureGathererOpenWeatherImpl TEMPERATURE_GATHERER_OPEN_WEATHER = new TemperatureGathererOpenWeatherImpl();

    /**
     * run method
     * will send SMS with temperature from API
     */
    @Override
    public void run() {
        SEND_SMS.sendSMS(TEMPERATURE_GATHERER_OPEN_WEATHER.getTemperature());
    }

}
