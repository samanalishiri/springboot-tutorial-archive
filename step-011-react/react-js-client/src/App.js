import React, {Component} from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/user/read/all')
            .then(res => this.setState({users: res.data}));
    }

    render() {
        return (
            <div class="container">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3 class="panel-title">USERS LIST</h3></div>
                    <div class="panel-body">
                        <Link to="/create" class="btn btn-info">
                            <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>Add User
                        </Link>
                        <table class="table table-stripe">
                            <thead>
                            <tr>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Email</th>
                            </tr>
                            </thead>
                            <tbody>
                            {this.state.users.map(u =>
                                <tr key={u.id}>
                                    <td> {u.username}</td>
                                    <td> {u.password}
                                    </td>
                                    <td> {u.email}
                                    </td>
                                    <td><Link to={`/show/${u.id}`} class="btn btn-info">Show</Link></td>
                                </tr>
                            )
                            }
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        );
    }
}

export default App;