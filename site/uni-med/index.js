// Globals
var serverUrl = "mr2hd0llj3vw4d.messaging.solace.cloud";
var serverPort = 8000;
username = "solace-cloud-client";
password = "7ro1gs0aj5fqius84kd3lna12v";


// Create a client instance
client = new Paho.MQTT.Client(serverUrl, serverPort, "unimed-ui");
// set callback handlers
client.onConnectionLost = onConnectionLost;
client.onMessageArrived = onMessageArrived;

// connect the client
client.connect({
    onSuccess: onConnect,
    userName: 'solace-cloud-client',
    password: '7ro1gs0aj5fqius84kd3lna12v'
});

// Message
var template = {"path":"patient","method":"GET","data":""};

// called when the client connects
function onConnect() {
  // Once a connection has been made, make a subscription and send a message.
  console.log("onConnect");
  client.subscribe("patient");
  client.subscribe("checkin");
  message = new Paho.MQTT.Message(JSON.stringify(template));
  message.destinationName = "command";
  console.log(message);
  client.send(message);
}

// called when the client loses its connection
function onConnectionLost(responseObject) {
  if (responseObject.errorCode !== 0) {
    console.log("onConnectionLost:"+responseObject.errorMessage);
  }
}

// called when a message arrives
function onMessageArrived(message) {
  console.log("onMessageArrived:"+message.payloadString);
}


// Build JSON list
function buildList (json) {

    // Get base node
    let base = document.getElementById("patient-list");

    // Build all of the list items into a list box
    for (let i = 0; i < json.length; i++) {
        items.push(buildListItem(json[i].firstName+" "+json[i].lastName, json[i].recentHistory.previousCheckIns[0].room.id));
    }
}

function buildListItem (name, roomNumber) {

}