import React, { Component } from 'react';
import '../index.css';

class PatientInfo extends Component {

    constructor(props) {
        super(props);

        this.state = {
            value: props
        }
    }

    render() {
        return (

            <div>
                <h1>Some Text</h1>
            </div>

        );
    }

}

export default PatientInfo;