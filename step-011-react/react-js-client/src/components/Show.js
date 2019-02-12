import React, {Component} from 'react';
import axios from 'axios';
import {Link} from 'react-router-dom';

class Show extends Component {

    constructor(props) {
        super(props);
        this.state = {
            user: {}
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/user/read/' + this.props.match.params.id)
            .then(res => {
                this.setState({user: res.data});
            });
    }

    delete(id) {
        axios.delete('http://localhost:8080/user/delete/' + id)
            .then((result) => this.props.history.push("/"));
    }

    render() {
        return (
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 class="panel-title">User Details</h3></div>
                    <div class="panel-body">
                        <dl>
                            <dt> Username :</dt>
                            <dd> {this.state.user.username}</dd>
                            <dt> Password :</dt>
                            <dd> {this.state.user.password}</dd>
                            <dt> Email Address:</dt>
                            <dd> {this.state.user.email}</dd>
                        </dl>
                        <Link to={`/Edit/${this.state.user.id}`} class="btn btn-info">Edit</Link>
                        &nbsp;
                        <button onClick={this.delete.bind(this, this.state.user.id)} class="btn btn-info">Delete
                        </button>
                        &nbsp;
                        <Link to="/" class="btn btn-info">
                            <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>Back
                        </Link>
                    </div>
                </div>
            </div>
        );
    }
}

export default Show;