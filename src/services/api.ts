import axios from 'axios';
import { User } from '../types/user';

export const api = axios.create({
  baseURL: 'http://localhost:8080/api'
});

export const userService = {
  create: async (userData: Omit<User, 'id'>) => {
    const response = await api.post('/users', userData);
    return response.data;
  },
  
  getAll: async () => {
    const response = await api.get('/users');
    return response.data;
  }
}; 