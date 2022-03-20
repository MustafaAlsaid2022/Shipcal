import React, { Component } from "react";

class CreateShipment extends Component {
  emptyShipment = {
    name: "",
    weight: 0,
    color: "#ff0000",
    destination: "Sweden",
  };

  constructor(props) {
    super(props);
    this.state = {
      shipment: this.emptyShipment,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let shipment = { ...this.state.shipment };
    shipment[name] = value;
    this.setState({ shipment });
  }

  async handleSubmit(event) {
    const { shipment } = this.state;
    const color = shipment.color;
    const r = parseInt(color.slice(1, 3), 16);
    const g = parseInt(color.slice(3, 5), 16);
    const b = parseInt(color.slice(5, 7), 16);
    const isEmpty =
      !shipment.name ||
      !shipment.weight ||
      !shipment.color ||
      !shipment.destination;

    event.preventDefault();
    
    if (shipment.weight < 0) {
      alert("weight is sould be positive value");
    } else if (b > g && b > r) {
      alert("Blue shade box is not allowed..!!!");
    } else if (isEmpty) {
      alert("No field should be empty");
    } else {
      await fetch("http://localhost:8080/api/addBoxes", {
        method: "POST",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json",
        },
        body: JSON.stringify(shipment),
      });
      alert("Created!!");
      window.location = "/listBoxes";
    }
  }

  render() {
    return (
      <div>
        <div className="main-container">
          <div className="box">
            <h2>Create New Shipment</h2>
            <form onSubmit={this.handleSubmit}>
              <div class="input-box">
                <input
                  type="text"
                  name="name"
                  defaultValue={this.state.shipment.name || ""}
                  onChange={this.handleChange}
                />
                <label>Name</label>
              </div>
              <div className="input-box">
                <input
                  type="text"
                  name="weight"
                  defaultValue={this.state.shipment.weight || ""}
                  onChange={this.handleChange}
                />
                <label> Weight </label>
              </div>

              <div>
                <label className="inline"> Box Color </label>
                <input
                  type="color"
                  name="color"
                  defaultValue={this.state.shipment.color || "#ff0000"}
                  onChange={this.handleChange}
                />
              </div>
              <div>
                <label className="inline"> Destination </label>
                <div className="select-dropdown inline">
                  <select
                    name="destination"
                    defaultValue={this.state.shipment.destination || ""}
                    onChange={this.handleChange}
                  >
                    <option value="Sweden">Sweden</option>
                    <option value="China">China</option>
                    <option value="Brazil">Brazil</option>
                    <option value="Australia">Australia</option>
                  </select>
                </div>
              </div>

              <div className="center">
                <input type="submit" value="Create" />
              </div>
            </form>
          </div>
        </div>
      </div>
    );
  }
}

export default CreateShipment;
