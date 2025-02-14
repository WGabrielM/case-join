import { User } from '../types/user';

export function UserList({ users }: { users: User[] }) {
  return (
    <div className="user-list">
      <h2>Registered Users</h2>
      <div className="user-table">
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>CPF</th>
              <th>Email</th>
              <th>Phone</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user) => (
              <tr key={user.id}>
                <td>{user.name}</td>
                <td>{user.cpf}</td>
                <td>{user.email}</td>
                <td>{user.telephone}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
} 