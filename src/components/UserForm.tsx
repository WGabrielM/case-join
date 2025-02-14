import { useState } from 'react';
import { userService } from '../services/api';

export function UserForm({ onUserCreated }: { onUserCreated: () => void }) {
  const [formData, setFormData] = useState({
    name: '',
    cpf: '',
    email: '',
    telephone: ''
  });
  const [errors, setErrors] = useState({
    name: '',
    cpf: '',
    email: '',
    telephone: ''
  });

  const validateForm = () => {
    let isValid = true;
    const newErrors = { ...errors };

    // Name validation
    if (!formData.name.trim()) {
      newErrors.name = 'Name is required';
      isValid = false;
    }

    // CPF validation (basic format XXX.XXX.XXX-XX)
    const cpfRegex = /^\d{3}\.\d{3}\.\d{3}-\d{2}$/;
    if (!cpfRegex.test(formData.cpf)) {
      newErrors.cpf = 'Invalid CPF format';
      isValid = false;
    }

    // Email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(formData.email)) {
      newErrors.email = 'Invalid email format';
      isValid = false;
    }

    // Phone validation (basic format)
    const phoneRegex = /^\(\d{2}\)\s\d{4,5}-\d{4}$/;
    if (!phoneRegex.test(formData.telephone)) {
      newErrors.telephone = 'Invalid phone format (XX) XXXXX-XXXX';
      isValid = false;
    }

    setErrors(newErrors);
    return isValid;
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    
    if (!validateForm()) return;

    try {
      await userService.create(formData);
      onUserCreated();
      setFormData({ name: '', cpf: '', email: '', telephone: '' });
    } catch (error) {
      console.error('Error creating user:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="user-form">
      <div className="form-group">
        <input
          type="text"
          placeholder="Name"
          value={formData.name}
          onChange={(e) => setFormData({ ...formData, name: e.target.value })}
        />
        {errors.name && <span className="error">{errors.name}</span>}
      </div>

      <div className="form-group">
        <input
          type="text"
          placeholder="CPF (XXX.XXX.XXX-XX)"
          value={formData.cpf}
          onChange={(e) => setFormData({ ...formData, cpf: e.target.value })}
        />
        {errors.cpf && <span className="error">{errors.cpf}</span>}
      </div>

      <div className="form-group">
        <input
          type="email"
          placeholder="Email"
          value={formData.email}
          onChange={(e) => setFormData({ ...formData, email: e.target.value })}
        />
        {errors.email && <span className="error">{errors.email}</span>}
      </div>

      <div className="form-group">
        <input
          type="text"
          placeholder="Phone (XX) XXXXX-XXXX"
          value={formData.telephone}
          onChange={(e) => setFormData({ ...formData, telephone: e.target.value })}
        />
        {errors.telephone && <span className="error">{errors.telephone}</span>}
      </div>

      <button type="submit">Register User</button>
    </form>
  );
} 