// src/SignUpForm.js
import React, { useState } from 'react';
import './LoginForm.css'; // Создадим файл для стилей, если необходимо

const SignUpForm = () => {
    const [name, setName] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        const formData = {
            name: name,
        };

        // Отправка данных на сервер
        fetch('http://localhost:8080/api/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData),
        })
        .then(response => {
            if (response.ok) {
            console.log(response);
                return response.json();
            }
            throw new Error('Network response was not ok');
        })
        .then(data => {
            console.log('Success:', data);
        })
        .catch(error => {
            console.error('Error:', error);
        });

        // Сброс формы
        setName('');
    };

    return (
        <div className="row">
            <div className="col-md-12">
                <form onSubmit={handleSubmit}>
                    <h1> Login </h1>
                    <fieldset>
                        <label htmlFor="name">Name:</label>
                        <input
                            type="text"
                            id="name"
                            name="name"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            required
                        />
                        {/* Поля email и password закомментированы, их можно восстановить при необходимости
                        <label htmlFor="email">Email:</label>
                        <input type="email" id="mail" name="user_email" required />

                        <label htmlFor="password">Password:</label>
                        <input type="password" id="password" name="user_password" required />
                        */}
                    </fieldset>
                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    );
};

export default SignUpForm;
