import React from "react";
import officeImg from "./office.jpg";

function App() {
  const office = {
    name: "Skyline Tech Park",
    rent: 55000,
    address: "Chennai",
  };

  const officeSpaces = [
    {
      name: "Skyline Tech Park",
      rent: 55000,
      address: "Chennai",
    },
    {
      name: "DLF IT Park",
      rent: 75000,
      address: "Hyderabad",
    },
    {
      name: "Prestige Towers",
      rent: 62000,
      address: "Bangalore",
    },
  ];

  return (
    <div style={{ margin: "20px" }}>
      <h1>Office Space Rental App</h1>

      <img
        src={officeImg}
        alt="Office Space"
        width="500"
        height="300"
      />

      <h2>Featured Office</h2>

      <p><b>Name:</b> {office.name}</p>

      <p
        style={{
          color: office.rent < 60000 ? "red" : "green",
        }}
      >
        <b>Rent:</b> ₹{office.rent}
      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>Available Office Spaces</h2>

      {officeSpaces.map((item, index) => (
        <div
          key={index}
          style={{
            border: "1px solid black",
            padding: "10px",
            marginBottom: "10px",
          }}
        >
          <h3>{item.name}</h3>

          <p
            style={{
              color: item.rent < 60000 ? "red" : "green",
            }}
          >
            <b>Rent:</b> ₹{item.rent}
          </p>

          <p>
            <b>Address:</b> {item.address}
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
