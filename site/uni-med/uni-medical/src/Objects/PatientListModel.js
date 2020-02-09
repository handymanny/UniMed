import React, { Component } from 'react';
import '../index.css';

class PatientListModel extends Component {

    constructor(props) {
        super(props);
        this.state = {
            patients: props,
            hasProps: props.hasProps
        };

        console.log(this.state.patients);
        console.log(this.state.hasProps);
        console.log(typeof this.state.patients);
    }

    render() {
        if (this.state.hasProps) {
            return (
                <div className="divTable paleBlueRows">
                    <div className="divTableBody">
                        {this.state.patients.patients.map(patient => (
                            <PatientListItem key={patient.patientId} patient_name={patient.firstName +" "+patient.lastName} room={patient.recentHistory.previousCheckIns[0].room.id} />
                        ))};
                    </div>
                </div>
            );
        } else {
            return (
            <div>
                <h1>Loading elements</h1>
            </div>
            );
        }
    }
}

class PatientListItem extends Component {

    constructor(props) {
        super(props);

        this.state ={patient_name: props.patient_name, room: props.room};
    }

    render() {
        return (
            <div className="divTableRow">
                <div className="divTableCell" style={{padding: "15px"}}>
                    <strong>Patient Name: {this.state.patient_name}</strong><br />
                    <small style={{color: "grey"}}><strong>Room #: {this.state.room}</strong></small>
                </div>
            </div>
        )
    }
}

export default PatientListModel