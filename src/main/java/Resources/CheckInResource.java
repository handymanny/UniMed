package Resources;

import DataSource.CheckInDao;
import Message.Message;
import Models.CheckIn;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class CheckInResource {

    private CheckInDao dao;
    private Message message;

    public CheckInResource (Message message) {
        dao = new CheckInDao();
        this.message = message;
    }

    public void getMethod () throws MqttException {
        // Get method based on parameters
        if (message.getMethod().equals("GET")) {
            if (message.getData() != null && !message.getData().equals("")) {
                getCheckIn(message.getData());
            } else {
                getAllCheckIn();
            }
        }

        if (message.getMethod().equals("POST")) {
            createCheckIn(new Gson().fromJson(message.getData(), CheckIn.class));
        }
    }

    private void getCheckIn (String id) throws MqttException {
        // Get instance of MqttClient
        MqttMessage message = new MqttMessage(new Gson().toJson(dao.getCheckIn(id)).getBytes());
        message.setQos(0);
        publishThread("checkin", message, UniMed.mqttClient);
    }

    private void getAllCheckIn () throws MqttException {
        // Get instance of MqttClient
        MqttMessage message = new MqttMessage(new Gson().toJson(dao.getAllCheckIn()).getBytes());
        message.setQos(0);
        publishThread("checkin", message, UniMed.mqttClient);
    }

    private void createCheckIn (CheckIn checkIn) throws MqttException {
        // Create new patient
        dao.createCheckIn(checkIn);

        // Get instance of MqttClient
        MqttMessage message = new MqttMessage(new Gson().toJson(dao.getCheckIn(checkIn.getId())).getBytes());
        message.setQos(0);
        publishThread("checkin", message, UniMed.mqttClient);
    }

    public void publishThread (String topic, MqttMessage message, MqttClient mqttClient) {
        new Thread(() -> {
            try {
                mqttClient.publish(topic, message);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
