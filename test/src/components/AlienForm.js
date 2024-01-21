import React, {useContext, useState} from 'react';
import {Button, FormControl, InputLabel, MenuItem, Select, TableCell, TableRow, TextField} from '@mui/material';
import {AlienContext} from './AlienContext';

const AlienForm = ({onAddAlien}) => {
    const {commanders, chiefCommanders} = useContext(AlienContext);
    const [newAlien, setNewAlien] = useState({type: '', name: '', weapon: '', vehicle: '', commanderId: ''});
    const [errors, setErrors] = useState({});

    const handleFormChange = (event) => {
        setNewAlien({...newAlien, [event.target.name]: event.target.value});
    };

    const validate = () => {
        let tempErrors = {};
        tempErrors.name = newAlien.name ? "" : "Name is required.";
        tempErrors.type = newAlien.type ? "" : "Type is required.";
        if (newAlien.type === 'Warrior') {
            tempErrors.weapon = newAlien.weapon ? "" : "Weapon is required for warriors";
        }
        if (['Commander', 'ChiefCommander'].includes(newAlien.type)) {
            tempErrors.vehicle = newAlien.vehicle ? "" : "Vehicle is required for commanders and chief commanders";
        }
        setErrors(tempErrors);
        return Object.values(tempErrors).every(x => x === "");
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        if (validate()) {
            console.log("newAlien", newAlien);
            onAddAlien(newAlien);
            setNewAlien({type: '', name: '', weapon: '', vehicle: '', commanderId: ''});
        }
    };

    const getCommanderOptions = () => {
        const relevantList = newAlien.type === 'Warrior' ? commanders : chiefCommanders;
        return relevantList.map((commander, index) => (
            <MenuItem value={commander.id}
                      key={`${commander.id}-${index}-${commander.name}`}>{commander.name}</MenuItem>
        ));
    };

    return (
        <TableRow>
            <TableCell>
                <FormControl fullWidth error={!!errors.type}>
                    <InputLabel>Type</InputLabel>
                    <Select
                        name="type"
                        value={newAlien.type}
                        onChange={handleFormChange}
                        label="Type"
                    >
                        <MenuItem value="Warrior">Warrior</MenuItem>
                        <MenuItem value="Commander">Commander</MenuItem>
                        <MenuItem value="ChiefCommander">Chief Commander</MenuItem>
                    </Select>
                </FormControl>
            </TableCell>
            <TableCell align="right">
                <TextField
                    name="name"
                    value={newAlien.name}
                    onChange={handleFormChange}
                    error={!!errors.name}
                    helperText={errors.name}
                    fullWidth
                />
            </TableCell>
            <TableCell align="right">
                {newAlien.type === 'Warrior' && (
                    <FormControl fullWidth error={!!errors.weapon}>
                        <InputLabel>Weapon</InputLabel>
                        <Select
                            name="weapon"
                            value={newAlien.weapon}
                            onChange={handleFormChange}
                            label="Weapon"
                        >
                            <MenuItem value="Water gun">Water gun</MenuItem>
                            <MenuItem value="Pepper spray">Pepper spray</MenuItem>
                            <MenuItem value="Chopsticks">Chopsticks</MenuItem>
                        </Select>
                    </FormControl>
                )}
            </TableCell>
            <TableCell align="right">
                {['Commander', 'ChiefCommander'].includes(newAlien.type) && (
                    <FormControl fullWidth error={!!errors.vehicle}>
                        <InputLabel>Vehicle</InputLabel>
                        <Select
                            name="vehicle"
                            value={newAlien.vehicle}
                            onChange={handleFormChange}
                            label="Vehicle"
                        >
                            <MenuItem value="Bird scooter">Bird scooter</MenuItem>
                            <MenuItem value="Merkava tank">Merkava tank</MenuItem>
                            {newAlien.type === 'ChiefCommander' && <MenuItem value="Egged Bus">Egged Bus</MenuItem>}
                        </Select>
                    </FormControl>
                )}
            </TableCell>
            <TableCell align="right">
                {(newAlien.type === 'Warrior' || newAlien.type === 'Commander') && (
                    <FormControl fullWidth>
                        <InputLabel>Commander</InputLabel>
                        <Select
                            name="commanderId"
                            value={newAlien.commanderId}
                            onChange={handleFormChange}
                            label="Commander"
                        >
                            {getCommanderOptions()}
                        </Select>
                    </FormControl>
                )}
            </TableCell>
            <TableCell align="right">
                <Button onClick={handleSubmit}>Add</Button>
            </TableCell>
        </TableRow>
    );
};

export default AlienForm;
