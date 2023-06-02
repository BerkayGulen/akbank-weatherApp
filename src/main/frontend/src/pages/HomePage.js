import React, {Component} from 'react';
import {getWeatherData} from "../api/apiCalls";
import Button from "bootstrap/js/src/button";
import {Card, Col, Container, Row, Spinner} from "react-bootstrap";
import { useEffect, useState } from 'react';
import Swal from "sweetalert2";

const HomePage = props =>{

    const [weatherData, setWeatherData] = useState([]);
    const [city, setCity] = useState('');
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState();

    async function getWeatherDataWithButton(){
        try {
            setError();
            setWeatherData([]);
            setLoading(true);

            const response = await getWeatherData(city);
            debugger
            setWeatherData(response.data.data.list);


        } catch (e) {
            debugger
            setError(e.response.data.data.message);
            await Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: e.response.data.data.message,
            });
        } finally {
            setLoading(false);
        }
        }


        return (
            <>
                {loading ?
                    <div className='w-100 min-vh-100 d-flex justify-content-center align-items-center'>
                        <Spinner animation="border" role="status">
                            <span className="visually-hidden">Loading...</span>
                        </Spinner>
                    </div>
                    : <Container>
                        <Row className="d-flex">
                            <div className='text-center mt-5'>
                                <input type={"text"}  onChange={(e) => { setCity(e.target.value) }} />
                                <button className='btn btn-outline-primary ms-2' onClick={getWeatherDataWithButton} variant="primary">Submit</button>{' '}

                                {error ? <div className='text-danger'>
                                    {error}
                                </div> : <h3 className='mt-3'>  Weather in {city}
                                </h3>}
                            </div>

                            {weatherData.map((weatherData, index) =>
                                <Col sm={4} className="mt-3" key={index}>
                                    <Card className="p-3 shadow border-0 mt-3 rounded">
                                        <div className='d-flex justify-content-between'>
                                            <div>
                                                {weatherData.dt_txt}
                                            </div>
                                            <div>
                                                Current: {weatherData.main.temp} °C
                                            </div>
                                        </div>
                                        <div className="d-flex justify-content-center">
                                            <img src={`http://openweathermap.org/img/wn/${weatherData.weather[0].icon}@2x.png`} />
                                        </div>
                                        <div className='d-flex justify-content-between'>
                                            <div>
                                                {weatherData.weather[0].main}
                                            </div>
                                            <div>
                                                Feels like  {weatherData.main.feels_like} °C
                                            </div>
                                        </div>
                                    </Card>
                                </Col>
                            )}
                        </Row>

                    </Container>
                }

            </>

        );

}

export default HomePage;