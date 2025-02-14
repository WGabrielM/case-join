import { useState, useEffect } from 'react';
import { UserForm } from './components/UserForm';
import { UserList } from './components/UserList';
import { userService } from './services/api';
import { User } from './types/user';
import './App.css'

function App() {
  const [users, setUsers] = useState<User[]>([]);

  const fetchUsers = async () => {
    try {
      const data = await userService.getAll();
      setUsers(data);
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };

  useEffect(() => {
    fetchUsers();
  }, []);

  return (
    <div className="container">
      <h1>User Registration</h1>
      <UserForm onUserCreated={fetchUsers} />
      <UserList users={users} />
    </div>
  );
}

export default App
