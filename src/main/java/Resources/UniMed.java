package Resources;

import Message.CustomMqttCallback;
import Models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eclipse.paho.client.mqttv3.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import static spark.Spark.*;

public class UniMed {
    // Allow other classes to get instance of object
    public static MqttClient mqttClient;

    public static void main (String [] args) throws MqttException {
        // Setup Mqtt Client
        mqttClient = new MqttClient("tcp://mr2hd0llj3vw4d.messaging.solace.cloud:1883", "unimed");
        MqttConnectOptions connectionOptions = new MqttConnectOptions();
        connectionOptions.setCleanSession(true);
        connectionOptions.setUserName("solace-cloud-client");
        connectionOptions.setPassword("7ro1gs0aj5fqius84kd3lna12v".toCharArray());
        mqttClient.connect(connectionOptions);

        // Custom callback
        mqttClient.setCallback(new CustomMqttCallback());

        // Subscribe to backend event
        mqttClient.subscribe("command", 0);

//        for (int i = 0 ; i < 11; i++) {
//            System.out.println(UUID.randomUUID().toString());
//        }

    }

    public static MqttClient getMqttInstance () {
        return mqttClient;
    }
}
