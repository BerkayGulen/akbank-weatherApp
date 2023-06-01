import React, {Component} from 'react';
import Input from "../components/input";
import {login, signUp} from "../api/apiCalls";
import Swal from 'sweetalert2'

class UserLoginPage extends Component {
    state = {
        email:null,
        password:null
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

        } catch (error) {
            if (error.response.data.data.validationErrors){
                this.setState({errors:error.response.data.data.validationErrors});
            }
           await Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Something went wrong!',
                footer: '<a href="">Why do I have this issue?</a>'
            });
            console.log("direkt");

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
                        <button className={"btn btn-primary"} onClick={this.onClickLogin}>Login</button>
                    </div>

                </form>
            </div>
        );
    }
}

export default UserLoginPage;