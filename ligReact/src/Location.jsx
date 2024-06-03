import React, { useState, useEffect } from 'react';
import axios from 'axios'

const urlAPI = "http://localhost:8080/weather"

const LocationComponent = () => {
  const [climate, setClimate] = useState('');
  const [location, setLocation] = useState('');
  const [loading, setLoading] = useState(true);

  useEffect(() => {

    const getClimate = () => {
        const url = `${urlAPI}/current/condition/text?location=${location.split(',')[0]}`
        axios['get'](url).then(resp => {
            //setClimate(resp)
            //console.log(climate)
        })
      }

    const getLocation = async () => {
      try {
        const response = await fetch('https://ipapi.co/json/');
        const data = await response.json();
        const { city, region, country } = data;
        setLocation(`${city}, ${region}, ${country}`);
        setLoading(false);
        getClimate()
      } catch (error) {
        console.error('Erro ao obter localização:', error);
        setLoading(false);
      }
    };

    getLocation();
  }, []);

  getTemperature => {

  }

  return (
    <>
        <br/>
        <h1 style={{fontWeight: "bold"}} id="datetime"> Date Time </h1>
        <h2 id="time">{new Date().toLocaleTimeString()}</h2>

        <h1 style={{marginTop: "2%"}}>Clima</h1>
        <h2 id="clima">Ensolarado</h2>
        <h2>Sua localização atual é:</h2>

      {loading ? (
        <p>Obtendo localização...</p>
      ) : (
        <h2>{location.split(',')[0]}</h2>
      )}
    </>
  );
};

export default LocationComponent;
