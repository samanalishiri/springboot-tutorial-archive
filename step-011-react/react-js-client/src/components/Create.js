import React, {Component} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

class Create extends Component {

    onChange = (e) =
    const
> {
    state
    state = this.state
        [e.target.name] = e.target.value;
    this

    constructor() {
        super();
        this.state = {
            username: '',
            password: '',
            email: ''
        };
    }

.

    setState(state);
}

onSubmit = (e) =
>
{
    e.preventDefault();

    const {username, password, email} = this.state;

    axios.post('http://localhost:8080/user/create', {username, password, email})
        .then((result) = > {
        this.props.history.push("/")
})
    ;
}

render()
{
    const {username, password, email} = this.state;
    return (
        < div
class
    = "container" >
        < div
class
    = "panel panel-default" >
        < div
class
    = "panel-heading" >
        < h3
class
    = "panel-title" >
        ADD
    USER
    < /h3>
    < /div>
    < div
class
    = "panel-body" >
        < form
    onSubmit = {this.onSubmit
}>
<
    div
class
    = "form-group" >
        < label
    for= "username" > Username:
<
    /label>
    < input
    type = "text"
class
    = "form-control"
    name = "username"
    value = {username}
    onChange = {this.onChange
}
    placeholder = "Username" / >
        < /div>
        < div
class
    = "form-group" >
        < label
    for= "password" > Password:
<
    /label>
    < input
    type = "text"
class
    = "form-control"
    name = "password"
    value = {password}
    onChange = {this.onChange
}
    placeholder = "Password" / >
        < /div>
        < div
class
    = "form-group" >
        < label
    for= "email" > Email:
<
    /label>
    < input
    type = "email"
class
    = "form-control"
    name = "email"
    value = {email}
    onChange = {this.onChange
}
    placeholder = "Email Address" / >
        < /div>
        < button
    type = "submit"
class
    = "btn btn-info" > Save < /button>&nbsp;
        < Link
    to = "/"
class
    = "btn btn-info" > < span
class
    = "glyphicon glyphicon-th-list"
    aria - hidden = "true" > < /span>Back</
    Link >
    < /form>
    < /div>
    < /div>
    < /div>
)
    ;
}
}

export default Create;