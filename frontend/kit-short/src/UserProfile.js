import React, { useState } from 'react';

function UserProfile({ user }) {
    const [linkName, setLinkName] = useState('');
    const [linkId, setLinkId] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // Логика отправки новой ссылки может быть добавлена здесь
        console.log(`Добавлена ссылка: ${linkId}, ${linkName}`);

        // Очистка полей после отправки
        setLinkName('');
        setLinkId('');
    };

    return (
        <div className="user-profile">
            <h1>Профиль пользователя</h1>
            <p>{user.id}. {user.name}</p>
            <h2>Ссылки:</h2>
            <ul>
                {user.links.map(link => (
                    <li key={link.id}>
                        <a href={link.name} target="_blank" rel="noopener noreferrer">
                            {link.name}
                        </a> (ID: {link.id})
                    </li>
                ))}
            </ul>

            <h2>Добавить новую ссылку</h2>
            <form onSubmit={handleSubmit} >
                <div>
                    <label>
                        Ссылка:
                        <input
                            type="url"
                            value={linkName}
                            onChange={(e) => setLinkName(e.target.value)}
                            required
                        />
                    </label>
                </div>
                <button type="submit">Отправить</button>
            </form>
        </div>
    );
}

export default UserProfile;
