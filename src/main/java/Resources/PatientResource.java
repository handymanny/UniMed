package Resources;

import DataSource.PatientDao;
import Message.Message;
import Models.Patient;
import com.google.gson.Gson;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PatientResource {

    private PatientDao dao;
    private Message message;

    public PatientResource (Message message) {
        dao = new PatientDao();
        this.message = message;
    }

    public void getMethod () throws MqttException {
        // Get method based on parameters
        if (message.getMethod().equals("GET")) {
            if (message.getData() != null && !message.getData().equals("")) {
                getPatient(message.getData());
            } else {
                getAllPatients();
            }
        }

        if (message.getMethod().equals("POST")) {
            createPatient(new Gson().fromJson(message.getData(), Patient.class));
        }
    }

    private void getPatient (String id) throws MqttException {
        // Get instance of MqttClient
        MqttMessage message = new MqttMessage(new Gson().toJson(dao.getPatient(id)).getBytes());
        message.setQos(0);
        publishThread("patient", message, UniMed.mqttClient);
    }

    private void getAllPatients () throws MqttException {
        // Get instance of MqttClient
        MqttMessage message = new MqttMessage(new Gson().toJson(dao.getAllPatients()).getBytes());
        message.setQos(0);
        publishThread("patient", message, UniMed.mqttClient);
    }

    private void createPatient (Patient patient) throws MqttException {
        // Create new patient
        dao.createPatient(patient);

        // Get instance of MqttClient
        MqttMessage message = new MqttMessage(new Gson().toJson(dao.getPatient(patient.getPatientId())).getBytes());
        message.setQos(0);
        publishThread("patient", message, UniMed.mqttClient);
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
