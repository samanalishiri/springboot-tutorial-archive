import React, {Component} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

class Edit extends Component {

    onChange = (e) =
    const
    state
> {
    state = this.state.user [e.target.name] = e.target.value;
    this

    constructor(props) {
        super(props);
        this.state = {
            user: {}
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/user/read/' + this.props.match.params.id)
            .then(res = > {
            this.setState({user: res.data});
    })
        ;
    }

.

    setState({user: state});
}

onSubmit = (e) =
>
{
    e.preventDefault();

    const {id, username, password, email} = this.state.user;

    axios.put('http://localhost:8080/user/update', {id, username, password, email})
        .then((result) = > {
        this.props.history.push("/show/" + this.props.match.params.id)
})
    ;
}

render()
{
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
        EDIT
    Users
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
    value = {this.state.user.username
}
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
    value = {this.state.user.password
}
    onChange = {this.onChange
}
    placeholder = "password" / >
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
    value = {this.state.user.email
}
    onChange = {this.onChange
}
    placeholder = "Email Address" / >
        < /div>
        < button
    type = "submit"
class
    = "btn btn-info" > Save < /button>&nbsp;
        < Link
    to = {`/show/${this.state.user.id}`
} class
    = "btn btn-info" > < span
class
    = "glyphicon glyphicon-eye-open"
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

export default Edit;