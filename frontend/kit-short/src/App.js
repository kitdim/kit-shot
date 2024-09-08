import React, { useState } from 'react';
import SignUpForm from './SignUpForm';
import LoginForm from './LoginForm';
import UserProfile from './UserProfile';
import './App.css';

function App() {
    const [showLogin, setShowLogin] = useState(true);
    const [user, setUser] = useState(null); // Хранение данных о пользователе

    const toggleForm = () => {
        setShowLogin((prevState) => !prevState);
    };

    const handleLogin = (userData) => {
        setUser(userData); // Установка данных пользователя после входа
    };

    const handleRegister = (userData) => {
        setUser(userData); // Установка данных пользователя после регистрации
    };

    return (
        <div className="App">
            {user ? (
                <UserProfile user={user} />
            ) : showLogin ? (
                <LoginForm onSwitch={toggleForm} onLogin={handleLogin} />
            ) : (
                <SignUpForm onSwitch={toggleForm} onRegister={handleRegister} />
            )}
        </div>
    );
}

export default App;
