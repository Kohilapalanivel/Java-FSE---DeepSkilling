import React from "react";

function ListofPlayers() {

  const players = [
    { name: "Virat", score: 95 },
    { name: "Rohit", score: 84 },
    { name: "Gill", score: 67 },
    { name: "Rahul", score: 72 },
    { name: "Hardik", score: 60 },
    { name: "Jadeja", score: 76 },
    { name: "Surya", score: 88 },
    { name: "Pant", score: 55 },
    { name: "Ashwin", score: 70 },
    { name: "Shami", score: 45 },
    { name: "Bumrah", score: 92 }
  ];

  const lowScore = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>

      <h3>All Players</h3>

      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>

      <h3>Players with Score Below 70</h3>

      <ul>
        {lowScore.map((player, index) => (
          <li key={index}>
            {player.name} - {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListofPlayers;