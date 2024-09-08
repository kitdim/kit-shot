import React, { useState } from 'react';
import './SignUpForm.css'; // Создадим файл для стилей, если необходимо

const SignUpForm = ({ onSwitch, onRegister }) => {
    const [name, setName] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        const formData = {
            name: name,
        };

        // Отправка данных на сервер
        fetch('http://localhost:8080/api/users/registration', {
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

            // Здесь передаем данные о пользователе в родительский компонент
            onRegister(data); // Передача данных пользователя

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
                    <h1> Sign Up </h1>
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
                    <button type="submit">Sign Up</button>
                    <p> Already have an account?{' '}
                        <button type="button" onClick={onSwitch}>Login</button>
                    </p>
                </form>
            </div>
        </div>
    );
};

export default SignUpForm;
