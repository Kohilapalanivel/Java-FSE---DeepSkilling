import React from "react";

function FlightDetails() {
  return (
    <div style={{ textAlign: "center" }}>
      <h2>Flight Details</h2>

      <table
        border="1"
        cellPadding="10"
        style={{
          margin: "20px auto",
          borderCollapse: "collapse"
        }}
      >
        <thead>
          <tr>
            <th>Flight</th>
            <th>From</th>
            <th>To</th>
            <th>Price</th>
          </tr>
        </thead>

        <tbody>
          <tr>
            <td>AI101</td>
            <td>Chennai</td>
            <td>Delhi</td>
            <td>₹4500</td>
          </tr>

          <tr>
            <td>AI202</td>
            <td>Bangalore</td>
            <td>Mumbai</td>
            <td>₹5500</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default FlightDetails;