import React, { Component } from 'react';

 class AllShipment extends Component {
    state = {
        shipments: []
      };
    async componentDidMount() {
        const response = await fetch('http://localhost:8080/api/listBoxes');
        const body = await response.json();
        this.setState({shipments:body});
    }


    render() {
        const {shipments} = this.state;
        return (
            <div style={{"text-align": "bcenter"}}>
              <table>
    <tr>
        {/* <th>Id</th> */}
        <th>Receiver</th>
        <th>Weight</th>
        <th>Box colour</th>
        <th>Destination</th>
        <th>Cost</th>
      </tr>
                  
                  {shipments.map(shipment =>
                      <tr key={shipment.id}>
                        {/* <td>{shipment.id}</td> */}
                        <td>{shipment.name}</td>
                        <td>{shipment.weight}</td>
                        <td style={{background:shipment.color}} ></td>
                        <td>{shipment.destination}</td>
                        <td>{shipment.cost}</td>
                      </tr>
                  )}
                  </table>
                  </div>
        );
      }
   
}
export default AllShipment;
