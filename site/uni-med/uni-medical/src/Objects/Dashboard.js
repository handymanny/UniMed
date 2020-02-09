import React, {Component} from 'react';
import '../index.css';
import PatientListModel from './PatientListModel';
import messaging from "../Api/Messaging";
import PatientInfo from './PatientInfo';
import Paho from "paho-mqtt";


class Dashboard extends Component {

    constructor(props) {
        super(props);
        this.state = {
            connected: false,
            hasProps: false,
            patients: []
        };

        this.listView = React.createRef();
        messaging.register(this.handleMessage.bind(this));
    }

    componentDidMount() {
        if (this.state.connected) {
            this.updateLists();
        } else {
            messaging.connectWithPromise().then(response => {
                console.log("Succesfully connected to Solace Cloud.", response);
                messaging.subscribe("checkin");
                messaging.subscribe("patient");
                this.setState({
                    connected: true,
                    patients: this.state.patients
                });

                // Update lists on screen
                this.updateLists();
            }).catch(error => {
                console.log("Unable to establish connection with Solace Cloud, see above logs for more details.", error);
            });
        }
    }

    updateLists() {
        if (this.state.connected) {
            // Create payload
            let message = {
                path: "patient",
                method: "GET",
                data: ""
            };

            // Create & send
            console.log("Sending");
            let data = new Paho.Message(JSON.stringify(message));
            data.destinationName = "command";
            messaging.send(data);
        } else {
            console.log("No connection to solace server")
        }
    }

    handleMessage(message) {
        this.setState(state => {
            return {
                patients: JSON.parse(message.payloadString),
                connected: state.connected
            };
        });

        // Trigger Update
        if (this.state.patients.length > 0) {
            console.log("Patients values were updated");
            this.setState({
                connected: true,
                hasProps: true,
                patients: this.state.patients
            });
        }
        console.log("Updated patients")
    }

    render() {
        if (this.state.hasProps) {
            return (
                <div className="container-fluid h-100 ">
                    <div className="row no-gutters h-100">
                        <div className="col-3" id="sidebar">
                            <div className="row">
                                <div className="col-xs-12" id="patient-list">
                                    <PatientListModel patients={this.state.patients} hasProps={this.state.hasProps} />
                                </div>
                            </div>

                        </div>

                        <div className="main col-9">
                            <div className="row">
                                <div className="col-xs-12" id="toolbar">

                                </div>
                            </div>
                            <div className="row">
                                <PatientInfo/>
                                <div className="col-xs-12" id="patient-overview">
                                    <h2 id="patient-name">Last Name, First Name</h2>
                                    <p id="patient-age">Age:</p>
                                    <p id="patient-dob">Date of Birth:</p>
                                    <p id="patient-address">Address:</p>
                                    <p id="patient-info">Medical Info:</p>
                                    <p id="patient-symptoms">Symptoms:</p>
                                    <div className="row">
                                        <div className="col-xs-12" id="medical-history">
                                            <h2 id="hist-title">Medical History</h2>
                                            <p id="date">[Date] - </p>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            );
        } else {
            return (
                <div className="container-fluid h-100 ">
                    <div className="row no-gutters h-100">
                        <div className="col-3" id="sidebar">
                            <div className="row">
                                <div className="col-xs-12" id="patient-list">
                                    <h1>Loading</h1>
                                </div>
                            </div>

                        </div>

                        <div className="main col-9">
                            <div className="row">
                                <div className="col-xs-12" id="toolbar">

                                </div>
                            </div>
                            <div className="row">
                                <h1>Loading</h1>
                                <div className="col-xs-12" id="patient-overview">
                                    <h2 id="patient-name">Last Name, First Name</h2>
                                    <p id="patient-age">Age:</p>
                                    <p id="patient-dob">Date of Birth:</p>
                                    <p id="patient-address">Address:</p>
                                    <p id="patient-info">Medical Info:</p>
                                    <p id="patient-symptoms">Symptoms:</p>
                                    <div className="row">
                                        <div className="col-xs-12" id="medical-history">
                                            <h2 id="hist-title">Medical History</h2>
                                            <p id="date">[Date] - </p>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            );
        }
    }
}

export default Dashboard