import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);

    this.state = {
      employeeName: "",
      complaint: ""
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const refNo = Math.floor(Math.random() * 100000);

    alert(
      `Complaint Submitted Successfully!\nReference Number: ${refNo}`
    );

    this.setState({
      employeeName: "",
      complaint: ""
    });
  };

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "30px" }}>
        <h2>Ticket Raising App</h2>

        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Employee Name</label>
            <br />
            <input
              type="text"
              name="employeeName"
              value={this.state.employeeName}
              onChange={this.handleChange}
            />
          </div>

          <br />

          <div>
            <label>Complaint</label>
            <br />
            <textarea
              name="complaint"
              rows="5"
              cols="30"
              value={this.state.complaint}
              onChange={this.handleChange}
            ></textarea>
          </div>

          <br />

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;