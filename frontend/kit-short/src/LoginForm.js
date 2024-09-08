import React, { useState } from 'react';
import './LoginForm.css'; // Создадим файл для стилей, если необходимо

const LoginForm = ({ onSwitch, onLogin }) => {
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
                return response.json();
            }
            throw new Error('Network response was not ok');
        })
        .then(data => {
            console.log('Success:', data);

            // Передаем данные пользователя в родительский компонент
            onLogin(data); // Обработка успешного входа

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
                    </fieldset>
                    <button type="submit">Login</button>
                    <p> No account?{' '}
                        <button type="button" onClick={onSwitch}>Sign Up</button>
                    </p>
                </form>
            </div>
        </div>
    );
};

export default LoginForm;
