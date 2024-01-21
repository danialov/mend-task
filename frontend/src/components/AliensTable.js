import React, {useContext} from 'react';
import axios from 'axios';
import {Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from '@mui/material';
import AlienForm from './AlienForm';
import AlienTableRow from './AlienTableRow';
import {AlienContext} from './AlienContext';

const AliensTable = () => {
    const {aliens, setAliens} = useContext(AlienContext);

    const onAddAlien = (newAlien) => {
        axios.post('http://localhost:8080/aliens', newAlien)
            .then(response => {
                const addedAlien = response.data;
                setAliens(prevAliens => {
                    const updatedAliens = [addedAlien, ...prevAliens];
                    localStorage.setItem('aliens', JSON.stringify(updatedAliens));
                    return updatedAliens;
                });
            })
            .catch(error => {
                console.error('Error adding new alien:', error);
            });
    };


    return (
        <TableContainer component={Paper}>
            <Table aria-label="aliens table">
                <TableHead>
                    <TableRow>
                        <TableCell>Type</TableCell>
                        <TableCell align="right">Name</TableCell>
                        <TableCell align="right">Weapon</TableCell>
                        <TableCell align="right">Vehicle</TableCell>
                        <TableCell align="right">Commander Name</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    <AlienForm onAddAlien={onAddAlien}/>
                    {aliens.map((alien, index) => (
                        <AlienTableRow key={`${alien.id}-${index}`} alien={alien}/>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
};

export default AliensTable;

