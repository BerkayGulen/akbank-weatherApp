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
    onChange = event =>{
      const {name,value} = event.target;
      this.setState({
          [name]:value
      })
    };

     onClickSignUp = event=> {
        event.preventDefault();
        const {username,firstName,lastName,email,displayName,password} = this.state;
        const body = {username ,firstName,lastName,email,password};

        axios.post("/api/v1/users",body)
    }
    render() {
        return (
            <form>
                <h1>Sign up</h1>
                <div>
                    <label>Username</label>
                    <input name="username" onChange={this.onChange}/>
                </div>
                <div>
                    <label>Display Name</label>
                    <input name="firstName" onChange={this.onChange}/>
                </div>
                <div>
                    <label>Display Name</label>
                    <input name="lastName" onChange={this.onChange}/>
                </div>
                <div>
                    <label>Display Name</label>
                    <input name="email" onChange={this.onChange}/>
                </div>
                {/*<div>*/}
                {/*    <label>Display Name</label>*/}
                {/*    <input name="displayName" onChange={this.onChange}/>*/}
                {/*</div>*/}
                <div>
                    <label>Password</label>
                    <input name="password" type={"password"} onChange={this.onChange}/>
                </div>
                <div>
                    <label>Password Repeat</label>
                    <input name="passwordRepeat" type={"password"} onChange={this.onChange}/>
                </div>
                <button onClick={this.onClickSignUp}>Sign Up</button>


            </form>
        );
    }
}

export default UserSignUpPage;