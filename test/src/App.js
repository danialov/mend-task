import './App.css';
import AliensTable from './components/AliensTable';
import { AlienProvider } from './components/AlienContext';

function App() {
    return (
        <AlienProvider>
            <div className="App">
                <AliensTable />
            </div>
        </AlienProvider>
    );
}

export default App;
