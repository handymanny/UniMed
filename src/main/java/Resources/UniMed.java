package Resources;

import Message.CustomMqttCallback;
import Models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eclipse.paho.client.mqttv3.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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

        String patientId = UUID.randomUUID().toString();

        PatientHistory patientHistory = new PatientHistory(0, 0, 1, 2, 2, 1, 0, 2, 2, 0,
                1, 2, 0, 2, 2, 2, 1, 0);

        LabResults labResults = new LabResults("Cancer Tests", new Date(), "Lab was inconclusive there is no cancer in this man", new Date());

        Procedure procedure = new Procedure(new Date(), patientId,new ProcedureNotes("Nurse Bob", "Sometimes this man is not good"));


        ArrayList<CheckIn> apt = new ArrayList<>();
        apt.add(new CheckIn(new Date(), UUID.randomUUID().toString(), new Patient(), new Room(1), new Date()));
        apt.add(new CheckIn(new Date(), UUID.randomUUID().toString(), new Patient(), new Room(3), new Date()));
        apt.add(new CheckIn(new Date(), UUID.randomUUID().toString(), new Patient(), new Room(5), new Date()));
        apt.add(new CheckIn(new Date(), UUID.randomUUID().toString(), new Patient(), new Room(2), new Date()));


        RecentHistory history = new RecentHistory(apt, "Helga");


        Patient patient = new Patient(patientId, "Emmanuel", "Cunningham", "Manny", new Date(), new Date(), "23 Hosking PL", "Guelph", "Canada", "N1G3R9",
                "+1 (705) 812-4425", "+1 (519) 217-3146", patientHistory, labResults, procedure, history);


        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println(gson.toJson(patient));
    }

    public static MqttClient getMqttInstance () {
        return mqttClient;
    }
}
