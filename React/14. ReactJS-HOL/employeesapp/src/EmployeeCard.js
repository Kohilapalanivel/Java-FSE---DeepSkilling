import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  const cardStyle = {
    backgroundColor: theme === "dark" ? "#333" : "#f4f4f4",
    color: theme === "dark" ? "#fff" : "#000",
    border: "1px solid #ccc",
    borderRadius: "8px",
    padding: "15px",
    margin: "10px auto",
    width: "300px",
    textAlign: "center"
  };

  return (
    <div style={cardStyle}>
      <h3>Employee Details</h3>
      <p><b>ID:</b> {employee.id}</p>
      <p><b>Name:</b> {employee.name}</p>
      <p><b>Designation:</b> {employee.designation}</p>
      <p><b>Theme:</b> {theme}</p>
    </div>
  );
}

export default EmployeeCard;