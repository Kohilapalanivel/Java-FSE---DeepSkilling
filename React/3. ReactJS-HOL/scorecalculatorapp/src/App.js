import React from "react";
import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        name="Kohila"
        school="SGVS Higher Secondary School"
        total={450}
        goal={5}
      />
    </div>
  );
}

export default App;s
