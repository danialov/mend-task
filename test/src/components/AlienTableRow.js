import React from 'react';
import { TableCell, TableRow } from '@mui/material';

const AlienTableRow = ({ alien }) => {
    return (
        <TableRow>
            <TableCell>{alien.type}</TableCell>
            <TableCell align="right">{alien.name}</TableCell>
            <TableCell align="right">{alien.weapon || 'N/A'}</TableCell>
            <TableCell align="right">{alien.vehicle || 'N/A'}</TableCell>
            <TableCell align="right">{alien.commanderName || 'N/A'}</TableCell>
        </TableRow>
    );
};

export default AlienTableRow;
