import logo from './logo.svg';
import './App.css';
import userLoginPage from "./pages/UserLoginPage";
import userSignUpPage from "./pages/UserSignUpPage";
import homePage from "./pages/HomePage";
import UserSignUpPage from "./pages/UserSignUpPage";
import HomePage from "./pages/HomePage";
import {BrowserRouter, HashRouter, Redirect, Route, Switch} from "react-router-dom";
import UserLoginPage from "./pages/UserLoginPage";
import TopBar from "./components/TopBar";

function App() {
    return (
        <div>
            <HashRouter>
                <TopBar/>
                <Switch>
                    <Route exact path="/" component={HomePage}/>
                    <Route path="/login" component={UserLoginPage}/>
                    <Route path="/signUp" component={UserSignUpPage}/>
                    <Redirect to="/"/>
                </Switch>
            </HashRouter>
        </div>
    );
}

export default App;
