import React from "react";
import axios from "axios";


class UserSignUpPage extends React.Component {

    state = {
        username: null,
        firstName: null,
        lastName: null,
        email: null,
        // displayName: null,
        password: null,
        passwordRepeat: null
    }
    onChange = event => {
        const {name, value} = event.target;
        this.setState({
            [name]: value
        })
    };

    onClickSignUp = event => {
        event.preventDefault();
        const {username, firstName, lastName, email, password} = this.state;
        const body = {username, firstName, lastName, email, password};

        axios.post("/api/v1/users", body)
    }

    render() {
        return (
            <div className="container">
                <form>
                    <h1 className="text-center">Sign up</h1>
                    <div className="form-group">
                        <label >Username</label>
                        <input className={"form-control"} name="username" onChange={this.onChange}/>
                    </div>
                    <div>
                        <label>Display Name</label>
                        <input className={"form-control"} name="firstName" onChange={this.onChange}/>
                    </div>
                    <div>
                        <label>Display Name</label>
                        <input className={"form-control"} name="lastName" onChange={this.onChange}/>
                    </div>
                    <div>
                        <label>Display Name</label>
                        <input className={"form-control"} name="email" onChange={this.onChange}/>
                    </div>
                    <div>
                        <label>Password</label>
                        <input className={"form-control"} name="password" type={"password"} onChange={this.onChange}/>
                    </div>
                    <div>
                        <label>Password Repeat</label>
                        <input className={"form-control"} name="passwordRepeat" type={"password"} onChange={this.onChange}/>
                    </div>
                    <div className={"text-center "}>
                        <button className={"btn btn-primary"} onClick={this.onClickSignUp}>Sign Up</button>
                    </div>


                </form>

            </div>
        );
    }
}

export default UserSignUpPage;