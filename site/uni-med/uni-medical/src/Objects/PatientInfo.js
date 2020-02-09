import React, { Component } from 'react';
import '../index.css';

class PatientInfo extends Component {

    constructor(props) {
        super(props);

        this.state = {
            patient: props.patient[0]
        }
    }

    render() {
        return (
            <div className="col-md-9">
                <div className="row" id="customer_info_row">
                    <div className="col-md-2">
                        <img alt="/src/Images/user-placeholder.png" src="/src/Images/" className="rounded-circle" id="card-patient-image" />
                    </div>
                    <div className="col-md-7">
                        <div className="card bg-default">
                            <h5 className="card-header">
                                <strong id="card-patient-name">{this.state.patient.firstName+" "+this.state.patient.lastName}</strong>
                            </h5>
                            <div className="card-body">
                                <p className="card-patient-info">
                                    &emsp;<strong>Date of Birth: </strong>{this.state.patient.dateOfBirth}<br/>
                                    &emsp;<strong>Age: </strong>20
                                </p>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-3">
                        <address>
                            <p id="card-patient-street">{this.state.patient.address}</p><p id="card-patient-city">{this.state.patient.city},
                            {this.state.patient.zip}</p><p id="card-patient-phone"><abbr title="Phone">P:</abbr>{this.state.patient.cellPhone}</p>
                        </address>
                    </div>
                </div>
                <div className="row" id="patient-recorded-info">
                    <div className="col-md-12">
                        <h3 className="text-center">
                            Medical Information
                        </h3>
                        <div className="tabbable" id="tabs-389996">
                            <ul className="nav nav-tabs">
                                <li className="nav-item">
                                    <a className="nav-link active" href="#tab1" data-toggle="tab">Procedure</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#tab2" data-toggle="tab">Lab Results</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#tab3" data-toggle="tab">Family History</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#tab4" data-toggle="tab">Medical History</a>
                                </li>
                            </ul>
                            <div className="tab-content">
                                <div className="tab-pane active" id="tab1">
                                    <div className="row">
                                        <div className="col-md-12">
                                            <table className="table">
                                                <tbody>
                                                <tr className="table-success">
                                                    <td>
                                                        Checked in Date
                                                    </td>
                                                    <td id="patient-procedure-date">
                                                        {this.state.patient.procedure.checkInDate}
                                                    </td>
                                                </tr>
                                                <tr className="table-success">
                                                    <td>
                                                        Patient ID
                                                    </td>
                                                    <td id="patient-procedure-id">
                                                        {this.state.patient.procedure.patientId}
                                                    </td>
                                                </tr>
                                                <tr className="table-success">
                                                    <td>
                                                        Room Number
                                                    </td>
                                                    <td id="patient-procedure-room">
                                                        {this.state.patient.procedure.room.notes}
                                                    </td>
                                                </tr>
                                                <tr className="table-success">
                                                    <td>
                                                        Notes
                                                    </td>

                                                    <td id="patient-procedure-notes">
                                                        {this.state.patient.procedure.notes}
                                                    </td>
                                                </tr>
                                                <tr className="table-success">
                                                    <td>
                                                        Notes By
                                                    </td>
                                                    <td id="patient-procedure-notesby">
                                                        {this.state.patient.procedure.submittedBy}
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div className="tab-pane" id="tab2">
                                    <div className="row">
                                        <div className="col-md-12">
                                            <table className="table table-striped">
                                                <thead>
                                                <tr>
                                                    <th id="lab-name">
                                                        {this.state.patient.labResults.labName}
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>
                                                        Lab Start Date
                                                    </td>
                                                    <td id="lab-start">
                                                        {this.state.patient.labResults.labStartDate}
                                                    </td>
                                                </tr>
                                                <tr id="table-active">
                                                    <td>
                                                        Lab Details
                                                    </td>
                                                    <td id="lab-details">
                                                        {this.state.patient.labResults.labDetails}
                                                    </td>
                                                </tr>
                                                <tr id="table-success">
                                                    <td>
                                                        Lab End Date
                                                    </td>
                                                    <td id="lab-end">
                                                        {this.state.patient.labResults.labEndDate}
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <div className="tab-pane" id="tab3">
                                    <p>
                                        <div className="row">
                                            <div className="col-md-12">
                                                <table className="table">
                                                    <thead>
                                                    <tr>
                                                        <th>
                                                            Illness
                                                        </th>
                                                        <th>
                                                            Mother
                                                        </th>
                                                        <th>
                                                            Father
                                                        </th>
                                                        <th>
                                                            Both
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr id="heart_disease">
                                                        <td>
                                                            Heart Disease
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="anemia">
                                                        <td>
                                                            Anemia
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="arthritis">
                                                        <td>
                                                            Arthritis
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="asthma">
                                                        <td>
                                                            Asthma
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="diabetes">
                                                        <td>
                                                            Diabetes
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="scarlet_fever">
                                                        <td>
                                                            Scarlet Fever
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="stroke">
                                                        <td>
                                                            Stroke
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="muscular_dystrophy">
                                                        <td>
                                                            Muscular Dystrophy
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="polio">
                                                        <td>
                                                            Polio
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="epilepsy">
                                                        <td>
                                                            Epilepsy
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="tuberculosis">
                                                        <td>
                                                            Tuberculosis
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="headaches">
                                                        <td>
                                                            Headaches
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="rheumatism">
                                                        <td>
                                                            Rheumatism
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="multiple_sclerosis">
                                                        <td>
                                                            Multiple Sclerosis
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="high_blood_pressure">
                                                        <td>
                                                            High Blood Pressure
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="hepatitis">
                                                        <td>
                                                            Hepatitis
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="caner">
                                                        <td>
                                                            Cancer
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    <tr id="kidney_disorder">
                                                        <td>
                                                            Kidney Disorder
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={2} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={3} style={{"align-content": "center"}}/>
                                                        </td>
                                                        <td>
                                                            <input type="checkbox" value={4} style={{"align-content": "center"}}/>
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </p>
                                </div>
                                <div className="tab-pane" id="tab4">
                                    <div className="row">
                                        <div className="col-md-12">
                                            <table className="table table-striped">
                                                <thead>
                                                <tr>
                                                    <th id="pat-name">
                                                        {this.state.patient.firstName +" "+ this.state.patient.lastName}
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>
                                                        Check-in Date
                                                    </td>
                                                    <td id="checkin-date">
                                                        {this.state.patient.recentHistory.previousCheckIns.checkedIn}
                                                    </td>
                                                </tr>
                                                <tr id="table-id">
                                                    <td>
                                                        ID No
                                                    </td>
                                                    <td id="id-no">
                                                        {this.state.patient.recentHistory.previousCheckIns.id}
                                                    </td>
                                                </tr>
                                                <tr id="table-room">
                                                    <td>
                                                        Room Number
                                                    </td>
                                                    <td id="room-no">
                                                        {this.state.patient.procedure.room.id}
                                                    </td>
                                                </tr>

                                                <tr id="table-checkout">
                                                    <td>
                                                        Check-out Date (if applicable)
                                                    </td>
                                                    <td id="checkout-date">
                                                        {this.state.patient.recentHistory.previousCheckIns.checkedOut}
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
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

export default PatientInfo;