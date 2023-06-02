import React from "react";
// import axios from "axios";
import {signUp} from '../api/apiCalls';
import Input from "../components/input";
import { Redirect } from 'react-router-dom';
import Swal from "sweetalert2";



class UserSignUpPage extends React.Component {

    state = {
        username: null,
        firstName: null,
        lastName: null,
        email: null,
        // displayName: null,
        password: null,
        pendingApiCall: false,
        errors: {},
        redirect: false

    }
    onChange = event => {
        const {name, value} = event.target;
        const errors = {...this.state.errors};
        errors[name] = undefined;
        this.setState({
            [name]: value,
            errors
        })
    };

    onClickSignUp = async event => {
        event.preventDefault();
        const {username, firstName, lastName, email, password} = this.state;
        const body = {username, firstName, lastName, email, password};
        this.setState({pendingApiCall: true});

        try {
            const response = await signUp(body);
            Swal.fire({
                position: 'bottom-end',
                icon: 'success',
                title: 'Successfully Signed in',
                showConfirmButton: false,
                timer: 1500
            });
            this.setState({ redirect: true })

        } catch (error) {
            if (error.response.data.data.validationErrors){
                this.setState({errors:error.response.data.data.validationErrors});
            }
        }
        this.setState({pendingApiCall: false})

    }

    render() {
        const {pendingApiCall,errors} = this.state;
        const {firstName,lastName,username,email,password} = errors;

        return (
            <div className="container pt-5">
                <form>
                    <h1 className="text-center">Sign up</h1>
                    <Input  label={"First Name"} name={"firstName"} error={firstName} onChange={this.onChange}></Input>
                    <Input  label={"Last Name"} name={"lastName"} error={lastName} onChange={this.onChange}></Input>
                    <Input  label={"UserName"} name={"username"} error={username} onChange={this.onChange}></Input>
                    <Input  label={"Email"} name={"email"} error={email} onChange={this.onChange}></Input>
                    <Input  label={"Password"} name={"password"} error={password} onChange={this.onChange} type={"password"}></Input>

                    <div className={"text-center pt-3 "}>
                        <button
                            className={"btn btn-outline-primary"}
                            onClick={this.onClickSignUp}
                            disabled={pendingApiCall}>
                            {pendingApiCall &&
                                <span className={"spinner-border spinner-border-sm"} role={"status"}
                                      aria-hidden={true}></span>}Sign Up
                        </button>
                    </div>
                </form>
                { this.state.redirect ? (<Redirect push to="/"/>) : null }

            </div>
        );
    }
}

export default UserSignUpPage;