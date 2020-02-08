package Message;

import Resources.CheckInResource;
import Resources.PatientResource;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMqttCallback implements MqttCallback {
    Logger log = LoggerFactory.getLogger(CustomMqttCallback.class);

    @Override
    public void connectionLost(Throwable throwable) {
        log.warn("Connection lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        log.info("Message received");

        // Get message
        String message = new String(mqttMessage.getPayload());

        // Check topic
        parseMessage(message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("Delivery complete");
    }

    // Endpoint route
    public void routeMessage (Message message) throws MqttException {

        // Check all possible endpoints
        switch (message.getPath()) {
            case "checkin":
                CheckInResource cir = new CheckInResource(message);
                cir.getMethod();
                break;

            case "patient":
                PatientResource pr = new PatientResource(message);
                pr.getMethod();
                break;

            default:
                log.info("Invalid request received");
        }
    }

    // Try and parse the incoming message from front end
    public void parseMessage (String data) {
        try {
            Message msg = new Gson().fromJson(data, Message.class);
            routeMessage(msg);
        } catch (Exception e) {
            log.warn("Invalid message data");
            log.warn(e.getMessage());
        }
    }
}
