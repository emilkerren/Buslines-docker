import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [busList, setBusList] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/buses');
        setBusList(response.data.BusList);
      } catch (error) {
        console.error(error);
      } finally {
        setIsLoading(false);
      }
    };
    fetchData();
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>Bus List</h1>
      {busList.map(bus => (
        <div key={bus.busNumber}>
          <h2>Bus {bus.busNumber}</h2>
          <p>Number of bus stops: {bus.numberOfBusStops}</p>
          <ul>
            {bus.busStops.map(stop => (
              <li key={stop}>{stop}</li>
            ))}
          </ul>
        </div>
      ))}
    </div>
  );
}

export default App;