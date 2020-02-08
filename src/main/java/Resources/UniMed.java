package Resources;

import Message.CustomMqttCallback;
import org.eclipse.paho.client.mqttv3.*;

import static spark.Spark.*;

public class UniMed {
    // Allow other classes to get instance of object
    public static MqttClient mqttClient;

    public static void main (String [] args) throws MqttException {
        // Setup Mqtt Client
        mqttClient = new MqttClient("tcp://mr2hd0llj3vw4d.messaging.solace.cloud:1883", "HelloWorldSub");
        MqttConnectOptions connectionOptions = new MqttConnectOptions();
        connectionOptions.setUserName("solace-cloud-client");
        connectionOptions.setPassword("7ro1gs0aj5fqius84kd3lna12v".toCharArray());
        mqttClient.connect(connectionOptions);

        // Custom callback
        mqttClient.setCallback(new CustomMqttCallback());

        // Subscribe to backend event
        mqttClient.subscribe("command", 0);

        // Base
        get("/hello", (req, res) -> "Hello World");
    }

    public static MqttClient getMqttInstance () {
        return mqttClient;
    }
}
