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
                <div className="container-fluid">
                    <div className="row" id="nav_bar_row">
                        <div className="col-md-12">
                            <ul className="nav nav-pills">
                                <li className="nav-item">
                                    <a className="nav-link active" href="#">Dashboard</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#">Check In</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#">Create Patient</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-3">
                            <div className="row" id="patients-list">
                                <input type="text" name="search" placeholder="Search Text" id="search-field"/>
                                <PatientListModel patients={this.state.patients} hasProps={this.state.hasProps} />
                            </div>
                        </div>
                    </div>
                    <PatientInfo patient={this.state.patients} />
                </div>
            );
        } else {
            return (
            <div className="container-fluid">
                <div className="row" id="nav_bar_row">
                    <div className="col-md-12">
                        <ul className="nav nav-pills">
                            <li className="nav-item">
                                <a className="nav-link active" href="#">Dashboard</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Check In</a>
                            </li>
                            <li className="nav-item">
                                <a className="nav-link" href="#">Create Patient</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div className="row">
                    <div className="col-md-3">
                        <div className="row" id="patients-list">
                            <input type="text" name="search" placeholder="Search Text" id="search-field"/>

                        </div>
                    </div>
                </div>
            </div>
            );
        }
    }
}

export default Dashboard;