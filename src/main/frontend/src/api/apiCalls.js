import axios from "axios";


export const signUp =(body)=>{
    return axios.post("/api/v1/users", body);
}

export const login = credentials =>{
    return axios.post("/api/v1/auth",credentials);
}

export const getWeatherData = (cityName) =>{
    return axios.get(`/api/v1/weather/forecast/${cityName}`);
}


