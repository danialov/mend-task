import React, {createContext, useEffect, useState} from 'react';
import axios from 'axios';

export const AlienContext = createContext();

export const AlienProvider = ({children}) => {
    const [aliens, setAliens] = useState([]);
    const [commanders, setCommanders] = useState([]);
    const [chiefCommanders, setChiefCommanders] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/aliens')
            .then(response => {
                if (response && Array.isArray(response.data)) {
                    setAliens(response.data);
                    setCommanders(response.data.filter(alien => alien.type === 'Commander'));
                    setChiefCommanders(response.data.filter(alien => alien.type === 'ChiefCommander'));
                }
            })
            .catch(error => {
                console.error('There was an error fetching the aliens:', error);
            });
        const handleStorageChange = (e) => {
            if (e.key === 'aliens') {
                setAliens(JSON.parse(e.newValue));
            }
        };

        window.addEventListener('storage', handleStorageChange);

        return () => {
            window.removeEventListener('storage', handleStorageChange);
        };
    }, []);

    return (
        <AlienContext.Provider value={{aliens, setAliens, commanders, chiefCommanders}}>
            {children}
        </AlienContext.Provider>
    );
};
