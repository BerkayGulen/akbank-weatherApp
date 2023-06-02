import React, {Component} from 'react';
import Input from "../components/input";
import {login, signUp} from "../api/apiCalls";
import Swal from 'sweetalert2'
import { Redirect } from 'react-router-dom';



class UserLoginPage extends Component {
    state = {
        email:null,
        password:null,
        redirect: false
    }


    onChange =event =>{
        const {name,value} = event.target;
        this.setState({
            [name]:value
        })
    }

    onClickLogin = async event =>{
        event.preventDefault();
        const credentials = {
            email:  this.state.email,
            password: this.state.password
        }
        try {
            const response = await login(credentials);
            Swal.fire({
                position: 'bottom-end',
                icon: 'success',
                title: 'Successfully Logged in',
                showConfirmButton: false,
                timer: 1500
            });
            this.setState({ redirect: true })



        } catch (error) {
            if (error.response.data.data.validationErrors){
                this.setState({errors:error.response.data.data.validationErrors});
            }
           await Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'wrong credentials :(',
            });

        }
    }

    render() {
        return (
            <div className={"container pt-5"}>
                <form>
                    <h1 className={"text-center"}>Login</h1>
                    <Input label={"Email"} name={"email"} onChange={this.onChange}></Input>
                    <Input label={"Password"} name={"password"} type={"password"} onChange={this.onChange}></Input>
                    <div className={"text-center pt-3"}>
                        <button className={"btn btn-outline-primary"} onClick={this.onClickLogin}>Login</button>
                    </div>
                </form>
                { this.state.redirect ? (<Redirect push to="/"/>) : null }
            </div>
        );
    }
}

export default UserLoginPage;