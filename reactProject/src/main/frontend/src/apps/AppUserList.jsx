import React, { useEffect, useState } from 'react';
import axios from 'axios';
import logo from '../logo.svg';
import '../App.css';

function App() {
  const [users, setUsers] = useState([]);


  useEffect(() => {
    axios.get('/rp/react/useDB')
      .then(res => setUsers(res.data))
      .catch(err => console.log(err));
  }, [])


  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h2>
          {users.map((user, index) => (
            <li key={index}>
              <p>UID: {user.uid}</p>
              <p>이름: {user.uname}</p>
              <p>Email: {user.email}</p>
            </li>
          ))}
        </h2>
      </header>

    </div>
  );
}

export default App;