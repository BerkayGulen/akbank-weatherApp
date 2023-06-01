import React, {Component} from 'react';
import {Link} from "react-router-dom";
import logo from '../assets/akbankLogo.jpg';

class TopBar extends Component {
    render() {
        return (
            <div className={"shadow-sm bg-dark  mb-2" }>
                <nav className="navbar navbar-dark  container   ">
                    <Link className="navbar-brand " to="/">
                          Akbank WeatherApp
                    </Link>

                        <ul className="navbar-nav" >
                            <li>
                                <Link className="nav-link" to="/login">Login</Link>
                            </li>
                            <li>
                                <Link className="nav-link" to="/signUp">Sign Up</Link>
                            </li>
                        </ul>
                </nav>
            </div>
        );
    }
}

export default TopBar;